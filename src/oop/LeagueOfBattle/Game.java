package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.Scanner;

public class Game {

    Champion champion1;
    Champion champion2;

   public Game(Champion champion1, Champion champion2) {
        this.champion1 = champion1;
        this.champion2 = champion2;
    }
    public void mainGame() {
        while (champion1.getHp() > 0 && champion2.getHp() > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println(" ");
            }
            System.out.print(champion1.getClass().getSimpleName() + "'s turn!            ");
            System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
            System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");

            startRounds();
        }
    }
    private void winning() {
        if (champion2.getHp() > champion1.getHp()) {
            System.out.println(champion2.getClass().getSimpleName() + " has won!");
        } else {
            System.out.println(champion1.getClass().getSimpleName() + " has won!");
        }
    }

    private void resetCooldowns() {
        champion1.resetCurrentActionPoints();
        champion2.resetCurrentActionPoints();
        champion1.resetCooldowns();
        champion2.resetCooldowns();
    }
    private void startRounds() {
        Scanner scan = new Scanner(System.in);
        Champion champion = champion1;
        Champion attackedChampion = champion2;
        String move;
        int turn = 1;
        resetCooldowns();
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
                    champion.ultimateSpell();
                    break;
                }
                case "rafalchamp": {
                    attackedChampion.getDemage(10000);
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
