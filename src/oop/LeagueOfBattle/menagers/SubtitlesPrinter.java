package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;

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
    public void printActionPoints(int actionPoints){
        println("Remaining action points: " + actionPoints);
    }
    public void printChampionList (ArrayList<Champion> champions){
        println("List of the Champions: " + champions);
    }
    public void printPlayer(int playerNumber){
        print("Player " + playerNumber + ": ");
    }
    private void print(String string) {
        System.out.print(string);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
