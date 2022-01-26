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
    protected boolean[] isSpellOnCooldown;
    public int currentActionPoints; //TODO why public
    protected boolean isUltimateOnCooldown; //todo abstraction around coldowns -> spells
    protected int ultimateCooldown; //todo abstrcation

    protected String soundPath;//todo interface? Sound provider?
    protected boolean assasin;  //todo interface?
    protected SoundHandler soundHandler = new SoundHandler(); //todo pass as argument / necessary?

    //???
    public abstract void getTrueDamage(float attackDimig);

    public abstract void getDamage(float attackDimig, float armor);

    //reset
    public final void resetCurrentActionPoints() { //
        currentActionPoints = actionPoints;
    }

    public final void resetCooldowns() {
        Arrays.fill(isSpellOnCooldown, false);
    }

    public final void resetUltimate() {
        isUltimateOnCooldown = false;
    }

    //spells
    public abstract void basicAttack(Champion champion);

    public abstract void spellQ(Champion champion);

    public abstract void spellW(); //todo missing champion

    public abstract void spellE(Champion champion);

    public abstract void ultimateSpell(Champion champion);

    public abstract void passiveSpell();

    //getters, setters
    public final String getName() {
        return name;
    }

    public final String getSound() {
        return soundPath;
    }

    public final float getHp() {
        return hp;
    }

    public final float getArmor() {
        return armor;
    }

    public final int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public int getUltimateCooldown() {
        return ultimateCooldown;
    }

    public final boolean isAssasin() {
        return assasin;
    }


    @Override
    public String toString() {
        return name;
    }

}
