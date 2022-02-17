package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.Ryze;
import oop.LeagueOfBattle.champions.Vladimir;
import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;

public class ChampionCreator {

    public static ArrayList<Champion> createChampions() {
        ArrayList<Champion> championsList = new ArrayList<>();
        Champion garen = new Garen();
        Champion rengar = new Rengar();
        Champion ryze = new Ryze();
        Champion vladimir = new Vladimir();
        championsList.add(garen);
        championsList.add(rengar);
        championsList.add(ryze);
        championsList.add(vladimir);
        return championsList;
    }
}
