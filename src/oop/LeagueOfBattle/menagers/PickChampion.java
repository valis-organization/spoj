package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PickChampion {
    ArrayList<Champion> champions;
    Scanner scan;
    public PickChampion(ArrayList<Champion> champions, Scanner scan) {
        this.champions = champions;
        this.scan = scan;
    }

    public Champion pickingChampion() {
        String championName = scan.next();
        switch (championName) {
            case "Garen": {
                System.out.println("You've chosen Garen, THE MIGHT OF DEMACIA!");
                Champion champion = findChampionByName(championName);
                champions.remove(champion);
                return champion;
            }
            case "Rengar": {
                System.out.println("You've chosen Rengar, THE PRIDESTALKER!");
                Champion champion = findChampionByName(championName);
                champions.remove(champion);
                return champion;
            }
            case "Ryze": {
                System.out.println("You've chosen Ryze, THE RUNE MAGE!");
                Champion champion = findChampionByName(championName);
                champions.remove(champion);
                return champion;
            }
            case "Vladimir": {
                System.out.println("You've chosen Vladimir, THE CRIMSON REAPER!");
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
