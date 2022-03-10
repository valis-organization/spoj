package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PickChampion {
    private final ArrayList<Champion> champions;
    private final Scanner scan;
    private final SubtitlesPrinter subtitlesPrinter;
    private final String GAREN = "Garen";
    private final String RENGAR = "Rengar";
    private final String RYZE = "Ryze";
    private final String VLADIMIR = "Vladimir";

    public PickChampion(ArrayList<Champion> champions, Scanner scan, SubtitlesPrinter subtitlesPrinter) {
        this.champions = champions;
        this.scan = scan;
        this.subtitlesPrinter = subtitlesPrinter;
    }

    public Champion pickingChampion() {
        String championName = scan.next();
        switch (championName) {
            case GAREN, RENGAR, RYZE, VLADIMIR -> {
                subtitlesPrinter.printChosenChampion(championName);
                Champion champion = findChampionByName(championName);
                champions.remove(champion);
                return champion;
            }
        }
        return null;
    }

    private Champion findChampionByName(String championName) {
        for (Champion champion : champions) {
            if (Objects.equals(championName, champion.getName())) {
                return champion;
            }
        }
        return null;
    }

}
