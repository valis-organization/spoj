package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.KeyType;
import oop.LeagueOfBattle.menagers.KeyboardManager;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

import java.util.concurrent.TimeUnit;

public class Game {
    Champion champion1;
    Champion champion2;
    int roundCount = 0;
    SubtitlesPrinter subtitlesPrinter;

    public Game(Champion champion1, Champion champion2, SubtitlesPrinter subtitlesPrinter) {
        this.subtitlesPrinter = subtitlesPrinter;

        if (champion2.isAssasin()) { // todo crate abstraction around the logic of picking first player to move
            this.champion1 = champion2;
            this.champion2 = champion1;
        } else {
            this.champion1 = champion1;
            this.champion2 = champion2;
        }
    }

    public void start() throws InterruptedException {
        while (!someChampionDied()) {
            roundCount++;
            printOnBeginningOfTheRound();

            Champion championInMove = champion1;
            Champion attackedChampion = champion2;
            while (championInMove.getCurrentActionPoints() > 0 || attackedChampion.getHp() > 0) {
                subtitlesPrinter.printActionPoints(championInMove.getCurrentActionPoints());
                Description spell;
                do {
                    spell = getSpell(KeyboardManager.getKey(), championInMove, attackedChampion);
                } while (spell == null);

                attackedChampion.receiveSpell(spell);
            }

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
                return champion.useAA();
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

    private void printOnBeginningOfTheRound() {
        subtitlesPrinter.printEnter(15);
        subtitlesPrinter.printRoundCount(roundCount);
        subtitlesPrinter.printTurn(champion1.getName());
        subtitlesPrinter.printHp(champion1);
        subtitlesPrinter.printHp(champion2);
    }
}
/* subtitlesPrinter.printEnter(1);
                    subtitlesPrinter.printTurn(championInMove.getName());
                    subtitlesPrinter.printHp(champion2);
                    subtitlesPrinter.printHp(champion1);

 */