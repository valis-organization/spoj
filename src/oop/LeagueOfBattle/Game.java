package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    Champion champion1;
    Champion champion2;
    int roundCount = 0;

    public Game(Champion champion1, Champion champion2) {
        if (champion2.isAssasin()) {
            this.champion1 = champion2;
            this.champion2 = champion1;
        } else {
            this.champion1 = champion1;
            this.champion2 = champion2;
        }
    }

    public void mainGame() throws InterruptedException {
        while (champion1.getHp() > 0 && champion2.getHp() > 0) {
            TimeUnit.SECONDS.sleep(2);
            for (int i = 0; i < 15; i++) {
                System.out.println(" ");
            }
            roundCount++;
            System.out.println("ROUND: " + roundCount + ". FIGHT!");
            resetCooldowns();
            System.out.print(champion1.getClass().getSimpleName() + "'s turn!            ");
            System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
            System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");

            startRounds();
        }
    }

    private void winning() {
        if (champion2.getHp() <= 0 || champion1.getHp() <= 0) {
            if (champion1.getHp() <= 0) {
                System.out.println(champion2.getClass().getSimpleName() + " has won!");
            } else {
                System.out.println(champion1.getClass().getSimpleName() + " has won!");
            }
        }
    }

    private void resetCooldowns() {
        champion1.resetCurrentActionPoints();
        champion2.resetCurrentActionPoints();
        champion1.resetCooldowns();
        champion2.resetCooldowns();
        if (roundCount % champion1.getUltimateCooldown() == 0) {
            champion1.resetUltimate();
            System.out.println(champion1 + "'s ULTIMATE SPELL COOLDOWN HAS BEEN RESET");
        } else if (roundCount % champion2.getUltimateCooldown() == 0) {
            champion2.resetUltimate();
            System.out.println(champion2 + "'s ULTIMATE SPELL COOLDOWN HAS BEEN RESET");
        }
        champion1.passiveSpell();
        champion2.passiveSpell();
    }

    private void startRounds() {
        Scanner scan = new Scanner(System.in);
        Champion champion = champion1;
        Champion attackedChampion = champion2;
        String move;
        int turn = 1;
        do {

            System.out.println("Remaining action points: " + champion.getCurrentActionPoints());
            move = scan.next();
            switch (move) {
                case "a": {
                    champion.basicAttack(attackedChampion);
                    break;
                }
                case "q": {
                    champion.spellQ(attackedChampion);
                    break;
                }
                case "w": {
                    champion.spellW();
                    break;
                }
                case "e": {
                    champion.spellE(attackedChampion);
                    break;
                }
                case "r": {
                    champion.ultimateSpell(attackedChampion);
                    break;
                }
                case "rafalchamp": {
                    attackedChampion.getDamage(10000, 0);
                    break;
                }
            }
            if (turn == 1 && champion.getCurrentActionPoints() == 0) {
                champion = champion2;
                attackedChampion = champion1;
                turn = 0;
                System.out.println();
                System.out.print(champion.getClass().getSimpleName() + "'s turn!              ");
                System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
                System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");
            } else if (turn == 0 && champion.getCurrentActionPoints() == 0) {
                champion = champion1;
                attackedChampion = champion2;
                turn = 1;
                System.out.println();
                System.out.print(champion.getClass().getSimpleName() + "'s turn!              ");
                System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
                System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");
            }

            if (champion.getHp() < 0) {
                break;
            }

        } while (champion1.getCurrentActionPoints() > 0 || champion2.getCurrentActionPoints() > 0);
        winning();
    }

}
