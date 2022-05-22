package oop.LeagueOfBattle.menagers;

import oop.LeagueOfBattle.champions.Garen;
import oop.LeagueOfBattle.champions.Rengar;
//import oop.LeagueOfBattle.champions.Ryze;
//import oop.LeagueOfBattle.champions.Vladimir;
import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.voiceLines.Garen.GarenVoiceHandler;
import oop.LeagueOfBattle.voiceLines.Rengar.RengarVoiceHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;
import oop.LeagueOfBattle.voiceLines.ryze.RyzeVoiceHandler;
import oop.LeagueOfBattle.voiceLines.vladimir.VladimirVoiceHandler;

import java.util.ArrayList;

public class ChampionCreator {

    public static ArrayList<Champion> createChampions(SoundHandler soundHandler, SubtitlesPrinter subtitlesPrinter) {
        GarenVoiceHandler garenVoiceHandler = new GarenVoiceHandler(soundHandler);
        RengarVoiceHandler rengarVoiceHandler = new RengarVoiceHandler(soundHandler);
        RyzeVoiceHandler ryzeVoiceHandler = new RyzeVoiceHandler(soundHandler);
        VladimirVoiceHandler vladimirVoiceHandler = new VladimirVoiceHandler(soundHandler);

        ArrayList<Champion> championsList = new ArrayList<>();
        Champion garen = new Garen(garenVoiceHandler, subtitlesPrinter);
        Champion rengar = new Rengar(rengarVoiceHandler, subtitlesPrinter);
     //   Champion ryze = new Ryze(ryzeVoiceHandler, subtitlesPrinter);
      //  Champion vladimir = new Vladimir(vladimirVoiceHandler, subtitlesPrinter);

        championsList.add(garen);
        championsList.add(rengar);
   //     championsList.add(ryze);
   //     championsList.add(vladimir);
        return championsList;
    }
}
