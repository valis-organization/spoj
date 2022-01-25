package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.voiceLines.SoundHandler;

import java.util.Arrays;

public abstract class Champion {
    protected String name;
    protected float hp;
    protected float armor;
    protected float magicResist;
    protected float abilityPower;
    protected float attackDimig;
    protected float armorPenetration;
    protected int actionPoints;
    public int currentActionPoints;
    protected boolean[] isSpellOnCooldown;
    protected String soundPath;
    protected boolean assasin;
    protected SoundHandler soundHandler = new SoundHandler();
    protected int randomVoice = (int) (Math.random() * 2);
    protected int requiredActionPoints;
    //int rand = (int)(Math.random() * range) + min;

    public abstract void getDemage(float attackDimig);

    public final float getHp() {
        return hp;
    }

    public final boolean isAssasin(){
        return assasin;
    }

    public final float getArmorPenetration() {
        return armorPenetration;
    }

    public final int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public final void resetCurrentActionPoints() {
        currentActionPoints = actionPoints;
    }
    public final String getName(){
        return name;
    }
    public final String getSound(){
        return soundPath;
    }
    public final void resetCooldowns() {
        Arrays.fill(isSpellOnCooldown, false);
    }

    public abstract void basicAttack(Champion champion);


    public abstract void spellQ(Champion champion);

    public abstract void spellW();

    public abstract void spellE(Champion champion);

    public abstract void ultimateSpell();

    public abstract void passiveSpell();
    @Override
    public String toString() {
        return name;
    }

}
