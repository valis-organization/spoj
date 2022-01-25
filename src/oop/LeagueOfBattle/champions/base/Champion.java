package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.voiceLines.SoundHandler;

import java.util.Arrays;

public abstract class Champion {
    protected String name;
    protected float maxHP;
    protected float hp;
    protected float armor;
    protected float magicResist;
    protected float abilityPower;
    protected float attackDimig;
    protected float armorPenetration;
    protected int actionPoints;
    public int currentActionPoints;
    protected boolean[] isSpellOnCooldown;
    protected boolean isUltimateOnCooldown;
    protected int ultimateCooldown;
    protected String soundPath;
    protected boolean assasin;
    protected SoundHandler soundHandler = new SoundHandler();
    protected int randomVoice = (int) (Math.random() * 2);
    protected int requiredActionPoints;
    //int rand = (int)(Math.random() * range) + min;


    public abstract void getDamage(float attackDimig, float armor);

    public abstract void getTrueDamage(float attackDimig);

    public final float getHp() {
        return hp;
    }

    public int getUltimateCooldown() {
        return ultimateCooldown;
    }

    public final boolean isAssasin() {
        return assasin;
    }

    public final float getArmor() {
        return armor;
    }

    public final int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public final void resetCurrentActionPoints() {
        currentActionPoints = actionPoints;
    }

    public final String getName() {
        return name;
    }

    public final String getSound() {
        return soundPath;
    }

    public final void resetCooldowns() {
        Arrays.fill(isSpellOnCooldown, false);
    }

    public final void resetUltimate() {
        isUltimateOnCooldown = false;
    }

    public abstract void basicAttack(Champion champion);


    public abstract void spellQ(Champion champion);

    public abstract void spellW();

    public abstract void spellE(Champion champion);

    public abstract void ultimateSpell(Champion champion);

    public abstract void passiveSpell();

    @Override
    public String toString() {
        return name;
    }

}
