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
        println(championName + "'s turn!            ");
    }

    public void printHp(Champion champion) {
        println(champion.getClass().getSimpleName() + ": " + champion.getHp() + " hp");
    }

    public void printWinner(String championName) {
        println(championName + " has won!");
    }

    public void printActionPoints(int actionPoints) {
        println("Remaining action points: " + actionPoints);
    }

    public void printChampionList(ArrayList<Champion> champions) {
        println("List of the Champions: " + champions);
    }

    public void printPlayerToPickNumber(int playerNumber) {
        print("Player " + playerNumber + ": ");
    }

    public void printStartBattle() {
        println("The battle will begin in 2 seconds!");
    }

    public void printChosenChampion(String championName) {
        System.out.println("You've chosen " + championName);
    }
    public void spellOnCooldown(){
        println("Your spell is on cooldown! Wait for the next round.");
    }

    private void print(String string) {
        System.out.print(string);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
