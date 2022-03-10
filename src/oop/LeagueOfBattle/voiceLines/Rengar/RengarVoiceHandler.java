package oop.LeagueOfBattle.voiceLines.Rengar;

import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

public class RengarVoiceHandler implements ChampionVoiceLineHandler {
    private final SoundHandler soundHandler;
    private final String Q1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarQ1.wav";
    private final String Q2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarQ2.wav";
    private final String W1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarW1.wav";
    private final String W2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarW2.wav";
    private final String E1 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarE1.wav";
    private final String E2 = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\RengarE2.wav";
    private final String Pick = "src\\oop\\LeagueOfBattle\\voiceLines\\Rengar\\PickRengar.wav";

    public RengarVoiceHandler(SoundHandler soundHandler) {
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

    }
}
