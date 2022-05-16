package oop.LeagueOfBattle.voiceLines.ryze;

import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

public class RyzeVoiceHandler implements ChampionVoiceLineHandler {
    private final SoundHandler soundHandler;
    public static String Q1 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\Q1.wav";
    public static String Q2 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\Q2.wav";
    public static String MQ1 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\MarkedQ1.wav";
    public static String MQ2 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\MarkedQ2.wav";
    public static String W1 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\W1.wav";
    public static String W2 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\W2.wav";
    public static String W3 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\W3.wav";
    public static String W4 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\W4.wav";
    public static String W5 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\W5.wav";
    public static String E1 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\E1.wav";
    public static String R1 = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\R1.wav";
    public static String Pick = "src\\oop\\LeagueOfBattle\\voiceLines\\ryze\\Pick.wav";

    public RyzeVoiceHandler(SoundHandler soundHandler) {
        this.soundHandler = soundHandler;
    }

    @Override
    public void playPickingSound() {
        soundHandler.playSound(Pick);
    }

    @Override
    public void playQSound() {
        int rand = MathHelper.randomInt(1, 4);
        if (rand == 1) {
            soundHandler.playSound(Q1);
        } else if (rand == 2) {
            soundHandler.playSound(Q2);
        } else if (rand == 3) {
            soundHandler.playSound(MQ1);
        } else if (rand == 4) {
            soundHandler.playSound(MQ2);
        }
    }
    @Override
    public void playWSound() {
        int rand = MathHelper.randomInt(1, 5);
        if (rand == 1) {
            soundHandler.playSound(W1);
        } else if (rand == 2) {
            soundHandler.playSound(W2);
        } else if (rand == 3) {
            soundHandler.playSound(W3);
        } else if (rand == 4) {
            soundHandler.playSound(W4);
        } else if (rand == 5) {
            soundHandler.playSound(W5);
        }
    }

    @Override
    public void playESound() {
        soundHandler.playSound(E1);
    }

    @Override
    public void playRSound() {
        soundHandler.playSound(R1);
    }
}


