package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.KeyType;
import oop.LeagueOfBattle.menagers.KeyboardMenager;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    Champion champion1;
    Champion champion2;
    int roundCount = 0;

    public Game(Champion champion1, Champion champion2) {
        if (champion2.isAssasin()) { // todo crate abstraction around the logic of picking first player to move
            this.champion1 = champion2;
            this.champion2 = champion1;
        } else {
            this.champion1 = champion1;
            this.champion2 = champion2;
        }
    }
    private Description getSpell(KeyType type, Champion champion, Enemy enemy){

        switch (type) {
            case AA: {
                return champion.useAA();
            }
            case Q: {
                return champion.useQ(enemy);
            }
            case W: {
                return champion.useW(enemy);
            }
            case E: {
                return champion.useE(enemy);
            }
            case R: {
                return champion.useR(enemy);
            }
        }
        return null;
    }
    boolean playerDied() {
        if (champion1.getHp() <= 0 || champion2.getHp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void start() throws InterruptedException {
        while (!playerDied()) {
            TimeUnit.SECONDS.sleep(2);
            for (int i = 0; i < 15; i++) { //todo abstraction around displaying stuff
                System.out.println(" ");
            }
            roundCount++;
            System.out.println("ROUND: " + roundCount + ". FIGHT!");
  //          resetCooldowns();
            System.out.print(champion1.getClass().getSimpleName() + "'s turn!            ");
            System.out.print(champion2.getClass().getSimpleName() + ": " + champion2.getHp() + " hp             ");
            System.out.println(champion1.getClass().getSimpleName() + ": " + champion1.getHp() + " hp");

            startRounds();
        }
    }

    private void determineWinner() {
        if (champion2.getHp() <= 0 || champion1.getHp() <= 0) { //todo can be simplified to if(champion1.getHp()  < champion2.getHp())...
            if (champion1.getHp() <= 0) {
                System.out.println(champion2.getClass().getSimpleName() + " has won!");
            } else {
                System.out.println(champion1.getClass().getSimpleName() + " has won!");
            }
        }
    }//todo return winning Champion
/*
    private void resetCooldowns() {
        champion1.resetCurrentActionPoints();
        champion2.resetCurrentActionPoints();
        champion1.resetCooldowns();
        champion2.resetCooldowns();
        if (roundCount % champion1.getUltimateCooldown() == 0) { //todo why is there such a logic? /abstract of comment
            champion1.resetUltimate();
            System.out.println(champion1 + "'s ULTIMATE SPELL COOLDOWN HAS BEEN RESET");
        } else if (roundCount % champion2.getUltimateCooldown() == 0) {
            champion2.resetUltimate();
            System.out.println(champion2 + "'s ULTIMATE SPELL COOLDOWN HAS BEEN RESET");
        }
        champion1.passiveSpell(); //todo using passive spell is not "resetColdown", change the name of the function so its more general
        champion2.passiveSpell();
    }
*/
    private void startRounds() {
        Scanner scan = new Scanner(System.in); //abstract whole thing to a controller class
        Champion champion = champion1;
        Champion attackedChampion = champion2;
        String move;
        KeyType type;
        int turn = 1; //todo change to shouldSwitchTurn(), int can be changed to Champion object
        //todo/ and name can be more descriptive then like: playerInMove : Champion
        do { //todo try not to use do{}while when simple while can be used
            System.out.println("Remaining action points: " + champion.getCurrentActionPoints());
            getSpell(KeyboardMenager.getKey(),champion,attackedChampion);

            if (turn == 1 && champion.getCurrentActionPoints() == 0) { //todo abstract to method e.g hasActionPoints(champion)
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
        determineWinner();
    }
}