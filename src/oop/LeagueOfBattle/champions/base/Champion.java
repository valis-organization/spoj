package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.voiceLines.SoundHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Champion {
    protected String name;
    //hp
    protected float maxHP;
    protected float hp;
    //defense
    protected float armor;
    protected float magicResist;
    //damage
    protected float abilityPower;
    protected float attackDimig;
    protected float armorPenetration;
    protected float magicPenetration;

    protected int actionPoints;
    public int currentActionPoints; //TODO why public

    protected String soundPath;//todo interface? Sound provider?
    protected boolean isAssasin;  //todo interface?
    protected SoundHandler soundHandler = new SoundHandler(); //todo pass as argument / necessary?

    protected List<Spell> spells = Collections.emptyList();
    abstract public void receiveSpell(Spell.Details details);

    abstract public Spell.Details useQ();
        //todo use spell or throw exception

    public List<Spell> usableSpells(){
        //todo
        return Collections.emptyList();
    }

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

    public final boolean isAssasin() {
        return isAssasin;
    }

    @Override
    public String toString() {
        return name;
    }

}
