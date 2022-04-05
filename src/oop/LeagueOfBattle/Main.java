package oop.LeagueOfBattle;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.menagers.ChampionCreator;
import oop.LeagueOfBattle.menagers.PickChampion;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;
import oop.LeagueOfBattle.voiceLines.SoundHandler;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SoundHandler soundHandler = new SoundHandler();
        SubtitlesPrinter subtitlesPrinter = new SubtitlesPrinter();
        Scanner scan = new Scanner(System.in);
        ArrayList<Champion> champions = ChampionCreator.createChampions(soundHandler, subtitlesPrinter);
        PickChampion pickingHandler = new PickChampion(champions, scan, subtitlesPrinter);
        //Picking Champions
        subtitlesPrinter.printChampionList(champions);
        subtitlesPrinter.printPlayerToPickNumber(1);
        Champion champion1 = pickingHandler.pickingChampion();

        subtitlesPrinter.printChampionList(champions);
        subtitlesPrinter.printPlayerToPickNumber(2);
        Champion champion2 = pickingHandler.pickingChampion();

        subtitlesPrinter.printStartBattle();

        Game game = new Game(champion1, champion2, subtitlesPrinter);
        game.start();
    }
}
