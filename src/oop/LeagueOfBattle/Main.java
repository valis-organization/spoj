package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.base.Hero;
import oop.LeagueOfBattle.voiceLines.voice;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    static void menuStart(){
        Scanner scan = new Scanner(System.in);

        System.out.println("////////////////////////////////////////");
        System.out.println("/         Greetings summoner!          /");
        System.out.println("////////////////////////////////////////");
        System.out.println("List of the Champions: " + champions());

    }
    static Hero pickingChampion(String character){
        String filepath = "C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\my-heart-and-sword-always-for-demacia (online-audio-converter.com).wav";
        voice voiceObject = new voice();

        Hero champion;
        switch(character){
            case "Garen":{
                System.out.println("You've chosen Garen, THE MIGHT OF DEMACIA!");
                System.out.println("Garen: My heart and sword always for Demacia.");
                voiceObject.playVoice(filepath);
                champion = new Garen();
                return champion;
            }
            case "Rengar":{
                System.out.println("You've chosen Rengar, THE PRIDESTALKER!");
                System.out.println("Rengar: Tonight, we hunt!");
                champion = new Rengar();
                return champion;
            }
        }
        return null;
    }
    static ArrayList<Hero> champions(){
        ArrayList<Hero> championsList= new ArrayList<>();
        Hero Garen = new Garen();
        Hero Rengar = new Rengar();
        championsList.add(Garen);
        championsList.add(Rengar);
        return championsList;
    }

    public static void winning(Hero champion1, Hero champion2) {
        if (champion2.getHp() > champion1.getHp()) {
            System.out.println(champion2.getClass().getSimpleName() + " has won!");
        } else {
            System.out.println(champion1.getClass().getSimpleName() + " has won!");
        }
    }

    public static void resetCooldowns(Hero champion1, Hero champion2) {
        champion1.resetCurrentActionPoints();
        champion2.resetCurrentActionPoints();
        champion1.resetCooldowns();
        champion2.resetCooldowns();
    }

    public static void mainGame(Hero champion1, Hero champion2) {
        Hero champion = champion1;
        while (champion1.getHp() > 0 && champion2.getHp() > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println(" ");
            }
            System.out.print(champion.getClass().getSimpleName() + "'s turn!            ");
            System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
            System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");

            startRounds(champion1, champion2);
        }
    }

    public static void startRounds(Hero champion1, Hero champion2) {
        Scanner scan = new Scanner(System.in);
        Hero champion = champion1;
        Hero attackedChampion = champion2;
        String move;
        int turn = 1;
        resetCooldowns(champion1, champion2);
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
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        menuStart();

        //Picking Champions
        System.out.print("Player 1: ");
        String character = scan.next();
        Hero champion1 = pickingChampion(character);
        System.out.print("Player 2: ");
        character = scan.next();
        Hero champion2 = pickingChampion(character);

        System.out.println("The battle will begin in 3 seconds!");
        TimeUnit.SECONDS.sleep(3);

        mainGame(champion1, champion2);
        winning(champion1, champion2);
    }

}
