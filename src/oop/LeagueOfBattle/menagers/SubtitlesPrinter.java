package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;

public class SubtitlesPrinter {

    public void printEnter(int enterCount) {
        for (int i = 0; i < enterCount; i++) {
            println(" ");
        }
    }

    public void printRoundCount(int roundCount) {
       println("ROUND: " + roundCount + ". FIGHT!");
    }

    public void printTurn(String championName) {
        print(championName + "'s turn!            ");
    }

    public void printHp(Champion champion) {
        println(champion.getClass().getSimpleName() + ": " + champion.getHp() + " hp");
    }
    public void printWinner(String championName){
        println(championName + " has won!");
    }

    private void print(String string) {
        System.out.print(string);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
