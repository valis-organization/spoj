package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.menagers.ChampionCreator;
import oop.LeagueOfBattle.menagers.PickingHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SoundHandler soundHandler = new SoundHandler();
        Scanner scan = new Scanner(System.in);
        ArrayList<Champion> champions = ChampionCreator.createChampions();
        PickingHandler pickingHandler = new PickingHandler(champions);
        //Picking Champions
        System.out.println("List of the Champions: " + champions);
        System.out.print("Player 1: ");
        String champion = scan.next();
        Champion champion1 = pickingHandler.pickingChampion(champion);
        soundHandler.playSound(champion1.getSound());

        System.out.println("List of the Champions: " + champions);
        System.out.print("Player 2: ");
        champion = scan.next();
        Champion champion2 = pickingHandler.pickingChampion(champion);
        soundHandler.playSound(champion2.getSound());

        System.out.println("The battle will begin in 2 seconds!");
     //   TimeUnit.SECONDS.sleep(3);

        Game game = new Game(champion1, champion2);
        game.mainGame();
    }

}
