package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
import oop.LeagueOfBattle.champions.Ryze;
import oop.LeagueOfBattle.champions.Vladimir;
import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.voiceLines.Garen.GarenVoiceHandler;
import oop.LeagueOfBattle.voiceLines.Rengar.RengarVoiceHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

import java.util.ArrayList;

public class ChampionCreator {

    public static ArrayList<Champion> createChampions(SoundHandler soundHandler) {
        GarenVoiceHandler garenVoiceHandler = new GarenVoiceHandler(soundHandler);
        RengarVoiceHandler rengarVoiceHandler = new RengarVoiceHandler(soundHandler);
        ArrayList<Champion> championsList = new ArrayList<>();
        Champion garen = new Garen(garenVoiceHandler);
        Champion rengar = new Rengar(rengarVoiceHandler);
        Champion ryze = new Ryze();
        Champion vladimir = new Vladimir();
        championsList.add(garen);
        championsList.add(rengar);
        championsList.add(ryze);
        championsList.add(vladimir);
        return championsList;
    }
}
