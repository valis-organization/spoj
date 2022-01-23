package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.base.Champion;

import java.util.ArrayList;

public class ChampionCreator {

   public static ArrayList<Champion> createChampions() {
        ArrayList<Champion> championsList = new ArrayList<>();
        Champion garen = new Garen();
        Champion rengar = new Rengar();
        championsList.add(garen);
        championsList.add(rengar);
        return championsList;
    }
}
