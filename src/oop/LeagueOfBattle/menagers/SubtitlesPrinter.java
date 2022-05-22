package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;

public class SubtitlesPrinter {

    public void printEnter(int enterCount) {
        for (int i = 0; i < enterCount; i++) {
            println(" ");
        }
    }
    //GAME
    public void printRoundCount(int roundCount) {
        println("ROUND: " + roundCount + ". FIGHT!");
    }

    public void printTurn(String championName) {println("================== " + championName + "'s turn! ==================");}

    public void printHp(Champion champion) {println(champion.getClass().getSimpleName() + ": " + champion.getHp() + " hp");}

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

    //CHAMPION SECTION
    public void spellOnCooldown() {println("Your spell is on cooldown! Wait for the next round.");}

    //GAREN
    public void garenPrintPassive(int regeneratedHp){println("Perseverance: Garen regenerated " + regeneratedHp + "HP.");}

    public void garenPrintSpinsCount(int spins){println("Garen spun " + spins + " times.");}

    //RENGAR
    public void rengarPrintPassive(){println("Bonetooth necklace: Rengar got +5 AD");}

    public void rengarSuccessfulHeal(int healedHp, int currentHp){println("Successfully healed for: " + healedHp + "hp, Your current hp is: " + currentHp);}

    public void rengarUnSuccessfulHeal(){println("You did not heal yourself.");}

    //RYZE
    public void ryzePrintPassive(int gainedAp){println("Arcane Mastery: Ryze read the ancient scrolls gaining " + gainedAp + " AP.");}

    public void ryzeResetQCooldown(){println("Ryze: Q COOLDOWN HAS BEEN RESET!");}

    public void ryzeResetWCooldown(){println("Ryze: W COOLDOWN HAS BEEN RESET!");}

    public void ryzeResetECooldown(){println("Ryze: E COOLDOWN HAS BEEN RESET!");}

    public void ryzeGainsActionPoint(){println("Ryze: Gained additional Action Point for this round.");}

    public void ryzeGainsAp(){println("Ryze: gained 5 AP");}

    public void ryzeBurnedScroll(){println("Ryze: The scroll has burned out. Nothing happens.");}

    //VLADIMIR
    public void vladimirPrintPassiveLostBlood(){println("Crimson Pact: Vladimir lost 20 blood.");}

    public void vladimirPrintPassiveGainedAp(int abilityPower){println("Crimson Pact: Vladimir gained 10 AP. Current AP: " + abilityPower);}

    public void vladimirLostBlood(int hpCost){println("Vladimir used " + hpCost + " to hp prepare his spell.");}

    //OTHERS
    private void print(String string) {
        System.out.print(string);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
