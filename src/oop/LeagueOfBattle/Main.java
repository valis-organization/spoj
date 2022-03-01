package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.menagers.ChampionCreator;
import oop.LeagueOfBattle.menagers.PickingHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;
import oop.LeagueOfBattle.voiceLines.SoundHandler;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SoundHandler soundHandler = new SoundHandler();
        SubtitlesPrinter subtitlesPrinter = new SubtitlesPrinter();
        Scanner scan = new Scanner(System.in);
        ArrayList<Champion> champions = ChampionCreator.createChampions(soundHandler);
        PickingHandler pickingHandler = new PickingHandler(champions);
        //Picking Champions
        subtitlesPrinter.printChampionList(champions);
        subtitlesPrinter.printPlayer(1);
        String champion = scan.next();
        Champion champion1 = pickingHandler.pickingChampion(champion);
        //soundHandler.playSound(champion1.getSound()); //todo I think it can be a part of pickingHandler

        subtitlesPrinter.printChampionList(champions);
        subtitlesPrinter.printPlayer(1);
        champion = scan.next(); //todo abstract
        Champion champion2 = pickingHandler.pickingChampion(champion);
      //  soundHandler.playSound(champion2.getSound());

        subtitlesPrinter.printStartBattle();

        Game game = new Game(champion1, champion2,subtitlesPrinter);
        game.start();
    }
}
