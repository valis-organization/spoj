package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellProvider;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;

import java.util.Arrays;


public abstract class Champion implements Enemy, SpellProvider {
    public ChampionVoiceLineHandler voiceHandler;
    protected String name;
    //hp
    protected int maxHP;
    protected int hp;
    //defense
    protected int armor;
    protected int magicResist;
    //damage
    protected int abilityPower;
    protected int attackDimig;
    protected float armorPenetration;
    protected float magicPenetration;
    protected int actionPoints;
    protected int currentActionPoints;
    protected boolean isAssassin;  //todo interface?
    protected boolean[] cooldown = new boolean[4];

    public Champion(ChampionVoiceLineHandler voiceHandler) {
        this.voiceHandler = voiceHandler;
    }
    String spellIsOnCooldown = "Your spell is on cooldown! Wait for the next round."; // TEMPORARY VARIABLE

    public final void receiveSpell(Description description) {
        int relativeArmor = (int) ((armor * (1 - armorPenetration * 0.01)) / 2); //TODO Naprawic bug, ktory polega na braniu armorPen od atakowanego championa
        int relativeMR = (int) ((magicResist * (1 - magicPenetration * 0.01)) / 2);
        relativeArmor = relativeArmor == 0 ? 1 : relativeArmor;
        relativeMR = relativeMR == 0 ? 1 : relativeMR;

        this.hp = hp - description.adDmg / relativeArmor;
        this.hp = hp - description.apDmg / relativeMR;
        this.hp = hp - description.trueDmg;
        this.currentActionPoints = currentActionPoints - description.removedActionPoints;

    }

    public Description useAA(Enemy enemy) {
        Spell AA = provideAA(enemy);
        currentActionPoints = currentActionPoints - AA.actionPointsCost;
        return new Description();
    }

    public final Description useQ(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[0])) {
            Spell spellQ = provideQ(enemy);
            voiceHandler.playQSound();
            currentActionPoints = currentActionPoints - spellQ.actionPointsCost;
            setOnCooldown(0);
            return spellQ.description;
        }
        System.out.println(spellIsOnCooldown);
        return new Description();
    }

    public final Description useW(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[1])) {
            Spell spellW = provideW(enemy);
            voiceHandler.playWSound();
            currentActionPoints = currentActionPoints - spellW.actionPointsCost;
            setOnCooldown(1);
            return spellW.description;
        }
        System.out.println(spellIsOnCooldown);
        return new Description();
    }

    public final Description useE(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[2])) {
            voiceHandler.playESound();
            Spell spellE = provideE(enemy);
            currentActionPoints = currentActionPoints - spellE.actionPointsCost;
            setOnCooldown(2);
            return provideE(enemy).description;
        }
        System.out.println(spellIsOnCooldown);
        return new Description();
    }

    public final Description useR(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[3])) {
            voiceHandler.playRSound();
            Spell spellR = provideR(enemy);
            currentActionPoints = currentActionPoints - spellR.actionPointsCost;
            setOnCooldown(3);
            return provideR(enemy).description;
        }
        System.out.println(spellIsOnCooldown);
        return new Description();
    }

    protected boolean isSpellOnCooldown(boolean whichSpell) {
        return whichSpell;
    }

    //reset
    public final void resetCurrentActionPoints() { //
        currentActionPoints = actionPoints;
    }

    //cooldowns
    public final void resetCooldowns() {
        Arrays.fill(cooldown, Boolean.FALSE);
    }

    protected void setOnCooldown(int spellNumber) {
        cooldown[spellNumber] = true;
    }

    //getters, setters
    public final String getName() {
        return name;
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

    public final boolean isAssassin() {
        return isAssassin;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public final int getHpPercentage() {
        return hp / maxHP;
    }
}
