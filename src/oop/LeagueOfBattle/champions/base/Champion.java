package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellProvider;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;


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
    protected boolean[] cooldown;

    public Champion(ChampionVoiceLineHandler voiceHandler) {
        this.voiceHandler = voiceHandler;
    }

    public final void receiveSpell(Description description) {
        int relativeArmor = (int) ((armor * (1 - armorPenetration)) / 2);
        int relativeMR = (int) ((magicResist * (1 - magicPenetration)) / 2);
        relativeArmor = relativeArmor == 0 ? 1 : relativeArmor;
        relativeMR = relativeMR == 0 ? 1 : relativeMR;

        this.hp = hp - description.addDmg / relativeArmor;
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
        Spell spellQ = provideQ(enemy);
        voiceHandler.playQSound();
        currentActionPoints = currentActionPoints - spellQ.actionPointsCost;
        return spellQ.description;
    }

    public final Description useW(Enemy enemy) {
        Spell spellW = provideW(enemy);
        voiceHandler.playWSound();
        currentActionPoints = currentActionPoints - spellW.actionPointsCost;
        return spellW.description;
    }

    public final Description useE(Enemy enemy) {
        voiceHandler.playESound();
        Spell spellE = provideE(enemy);
        currentActionPoints = currentActionPoints - spellE.actionPointsCost;
        return provideE(enemy).description;
    }

    public final Description useR(Enemy enemy) {
        voiceHandler.playRSound();
        Spell spellR = provideR(enemy);
        currentActionPoints = currentActionPoints - spellR.actionPointsCost;
        return provideR(enemy).description;
    }

    protected boolean isSpellOnCooldown(boolean whichSpell) {
        return whichSpell;
    }

    //reset
    public final void resetCurrentActionPoints() { //
        currentActionPoints = actionPoints;
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
