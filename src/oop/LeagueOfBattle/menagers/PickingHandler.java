package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

import java.util.ArrayList;
import java.util.Objects;

public class PickingHandler {
    ArrayList<Champion> champions;

    public PickingHandler(ArrayList<Champion> champions) {
        this.champions = champions;
    }

    private Champion findCharacter(String championName){
        for (Champion champion : champions) {
            if (Objects.equals(championName, champion.getName())) {
                return champion;
            }
        }
        return null;
    }

    public Champion pickingChampion(String championName) {

        switch (championName) {
            case "Garen": {
                System.out.println("You've chosen Garen, THE MIGHT OF DEMACIA!");
                Champion champion = findCharacter(championName);
                champions.remove(champion);
                return champion;
            }
            case "Rengar": {
                System.out.println("You've chosen Rengar, THE PRIDESTALKER!");
                Champion champion = findCharacter(championName);
                champions.remove(champion);
                return champion;
            }
        }
        return null;
    }

}
