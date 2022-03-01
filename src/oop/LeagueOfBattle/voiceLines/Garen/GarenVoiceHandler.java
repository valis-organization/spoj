package oop.LeagueOfBattle.voiceLines.Garen;

import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;


public class GarenVoiceHandler implements ChampionVoiceLineHandler {
    private SoundHandler soundHandler;

    private final String Q1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenQ1.wav";
    private final String Q2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenQ2.wav";
    private final String E1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenE1.wav";
    private final String E2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenE2.wav";
    private final String W1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenW1.wav";
    private final String W2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenW2.wav";
    private final String R1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenR1.wav";
    private final String R2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\GarenR2.wav";
    private final String Pick = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\PickGaren.wav";

    public GarenVoiceHandler(SoundHandler soundHandler) {
        this.soundHandler = soundHandler;
    }

    @Override
    public void playPickingSound() {
        soundHandler.playSound(Pick);
    }

    @Override
    public void playQSound() {
        if (MathHelper.randomBoolean()) {
            soundHandler.playSound(Q1);
        } else {
            soundHandler.playSound(Q2);
        }
    }

    @Override
    public void playWSound() {
        if (MathHelper.randomBoolean()) {
            soundHandler.playSound(W1);
        } else {
            soundHandler.playSound(W2);
        }
    }

    @Override
    public void playESound() {
        if (MathHelper.randomBoolean()) {
            soundHandler.playSound(E1);
        } else {
            soundHandler.playSound(E2);
        }
    }

    @Override
    public void playRSound() {
        if (MathHelper.randomBoolean()) {
            soundHandler.playSound(R1);
        } else {
            soundHandler.playSound(R2);
        }
    }
}
