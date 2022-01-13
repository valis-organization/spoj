package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.base.Hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hero champion1 = new Garen();
        Hero champion2 = new Rengar();
        int turn = 0;
        String move;
        Hero champion = champion1;

        while (champion2.hp > 0 && champion2.hp > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println(" ");
            }

            champion1.actionPoints = champion1.startingActionPoints;
            champion2.actionPoints = champion2.startingActionPoints;
            System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.hp + " hp             ");
            System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.hp + " hp");

            System.out.println(champion2.getClass().getSimpleName() + "'s turn!");
            do {

                System.out.println("Remaining action points: " + champion.actionPoints);
                move = scan.next();
                switch (move) {
                    case "a": {
                        champion.basicAttack(champion1);
                        break;
                    }
                    case "q": {
                        champion.spellQ(champion1);
                        break;
                    }
                    case "rafalchamp": {
                        champion.getDemage(10000);
                        break;
                    }
                }
                if (turn == 1) {
                    champion = champion1;
                    turn = 0;
                } else if(turn == 0){
                    champion = champion2;
                    turn = 1;
                }

                if(champion.hp < 0){
                    break;
                }
            } while (champion.actionPoints > 0);

            if (champion2.hp > champion1.hp) {
                System.out.println(champion2.getClass().getSimpleName() + " has won!");
            } else {
                System.out.println(champion1.getClass().getSimpleName() + " has won!");
            }
        }
    }

}
