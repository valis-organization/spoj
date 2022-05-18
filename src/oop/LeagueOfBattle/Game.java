package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.KeyType;
import oop.LeagueOfBattle.menagers.KeyboardManager;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

import java.util.concurrent.TimeUnit;

public class Game {
    private final Champion champion1;
    private final Champion champion2;
    private int roundCount = 0;
    private final SubtitlesPrinter subtitlesPrinter;

    public Game(Champion champion1, Champion champion2, SubtitlesPrinter subtitlesPrinter) {
        this.subtitlesPrinter = subtitlesPrinter;
        // todo crate abstraction around the logic of picking first player to move
            Champion firstPick = determineFirstPick(champion1,champion2);
            this.champion1 = firstPick;
            this.champion2 = determineSecondPick(firstPick,champion1,champion2);
    }

    public void start() throws InterruptedException {
        Champion championInMove = champion1;
        Champion attackedChampion = champion2;
        int turnCount = 0;
        while (!someChampionDied()) {
            turnCount++;
            if (turnCount % 2 != 0) {
                roundCount++;
                printOnBeginningOfTheRound();
                resetAbilities(championInMove, attackedChampion);
                usePassiveSpells(championInMove, attackedChampion);
            }

            while (championInMove.getCurrentActionPoints() > 0 && attackedChampion.getHp() > 0) {
                subtitlesPrinter.printActionPoints(championInMove.getCurrentActionPoints());
                Description spell;
                do {
                    spell = getSpell(KeyboardManager.getKey(), championInMove, attackedChampion);
                } while (spell == null);

                attackedChampion.receiveSpell(spell);
                subtitlesPrinter.printEnter(1);
                subtitlesPrinter.printHp(champion2);
                subtitlesPrinter.printHp(champion1);
            }
            Champion previousChampionInMove = championInMove;
            championInMove = attackedChampion;
            attackedChampion = previousChampionInMove;
            subtitlesPrinter.printTurn(championInMove.getName());

            Champion winner = determineWinner();
            if (winner != null) {
                subtitlesPrinter.printWinner(winner.getName());
            }
            TimeUnit.SECONDS.sleep(2); //Wait for subtitles to be read.
        }
    }

    private Description getSpell(KeyType type, Champion champion, Enemy enemy) {
        switch (type) {
            case AA -> {
                return champion.useAA(enemy);
            }
            case Q -> {
                return champion.useQ(enemy);
            }
            case W -> {
                return champion.useW(enemy);
            }
            case E -> {
                return champion.useE(enemy);
            }
            case R -> {
                return champion.useR(enemy);
            }
        }
        return null;
    }

    private boolean someChampionDied() {
        return champion1.getHp() <= 0 || champion2.getHp() <= 0;
    }

    private Champion determineWinner() {
        if (someChampionDied()) {
            if (champion1.getHp() < champion2.getHp()) {
                return champion2;
            } else {
                return champion1;
            }
        }
        return null;
    }

    private Champion determineFirstPick(Champion champion1, Champion champion2) {
        if (champion2.isAssassin()) {
            return champion2;
        }
        return champion1;
    }
    private Champion determineSecondPick(Champion firstPick, Champion champion1, Champion champion2){
      if(firstPick.equals(champion1)){
          return champion2;
       }
      return champion1;
    }
    private void resetAbilities(Champion championInMove, Champion attackedChampion) {
        championInMove.resetCurrentActionPoints();
        attackedChampion.resetCurrentActionPoints();
        championInMove.resetCooldowns();
        attackedChampion.resetCooldowns();
    }

    private void usePassiveSpells(Champion championInMove, Champion attackedChampion) {
        championInMove.usePassive(attackedChampion);
        attackedChampion.usePassive(championInMove);
    }

    private void printOnBeginningOfTheRound() {
        subtitlesPrinter.printEnter(15);
        subtitlesPrinter.printRoundCount(roundCount);
        subtitlesPrinter.printTurn(champion1.getName());
        subtitlesPrinter.printHp(champion1);
        subtitlesPrinter.printHp(champion2);
    }
}