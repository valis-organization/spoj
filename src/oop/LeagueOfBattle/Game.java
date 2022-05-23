package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.KeyType;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.menagers.KeyboardManager;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private final Champion champion1;
    private final Champion champion2;
    private int roundCount = 0;
    private final SubtitlesPrinter subtitlesPrinter;

    public Game(Champion champion1, Champion champion2, SubtitlesPrinter subtitlesPrinter) {
        this.subtitlesPrinter = subtitlesPrinter;
        // todo crate abstraction around the logic of picking first player to move
        Champion firstPick = determineFirstPick(champion1, champion2);
        this.champion1 = firstPick;
        this.champion2 = determineSecondPick(firstPick, champion1, champion2);
    }

    public void start() throws InterruptedException {
        Champion championInMove = champion1;
        Champion attackedChampion = champion2;


        int turnCount = 0;
        while (!someChampionDied()) {
            turnCount++;
            if (turnCount % 2 != 0) {
                roundCount++;
                subtitlesPrinter.printEnter(15);
                resetAbilities(championInMove, attackedChampion);
                usePassiveSpells(championInMove, attackedChampion);
                printOnBeginningOfTheRound();
            }

            while (championInMove.getCurrentActionPoints() > 0 && attackedChampion.getHp() > 0) {
                subtitlesPrinter.printActionPoints(championInMove.getCurrentActionPoints());
                Spell spell;
                do {
                    spell = getSpell(KeyboardManager.getKey(), championInMove);
                } while (spell == null);

                spell.use();
                attackedChampion.receiveSpell(spell.description);
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
        }
    }

    private Spell getSpell(KeyType type, Champion champion) {
        switch (type) {
            case AA -> {
                return champion.aaHandler();
            }
            case Q -> {
                return champion.spellQHandler();
            }
            case W -> {
                return champion.spellWHandler();
            }
            case E -> {
                return champion.spellEHandler();
            }
            case R -> {
                return champion.spellRHandler();
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

    private Champion determineSecondPick(Champion firstPick, Champion champion1, Champion champion2) {
        if (firstPick.equals(champion1)) {
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
        championInMove.providePassive().use();
        attackedChampion.providePassive().use();
    }

    private ArrayList<Spell> firstChampionSpells(Spell spellQ, Spell spellW, Spell spellE, Spell spellR) {
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(spellQ);
        spells.add(spellW);
        spells.add(spellE);
        spells.add(spellR);
        return spells;
    }

    private ArrayList<Spell> secondChampionSpells(Spell spellQ, Spell spellW, Spell spellE, Spell spellR) {
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(spellQ);
        spells.add(spellW);
        spells.add(spellE);
        spells.add(spellR);
        return spells;
    }

    private void printOnBeginningOfTheRound() {
        subtitlesPrinter.printHp(champion1);
        subtitlesPrinter.printHp(champion2);
        subtitlesPrinter.printEnter(1);
        subtitlesPrinter.printRoundCount(roundCount);
        subtitlesPrinter.printEnter(1);
        subtitlesPrinter.printTurn(champion1.getName());
    }
}