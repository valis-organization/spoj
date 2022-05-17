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
    //ActionPoints and Cooldowns
    protected int actionPoints;
    protected int currentActionPoints;
    protected int costQ;
    protected int costW;
    protected int costE;
    protected int costR;
    protected boolean[] cooldown = new boolean[4];

    protected boolean isAssassin;  //todo interface?

    public Champion(ChampionVoiceLineHandler voiceHandler) {
        this.voiceHandler = voiceHandler;
    }

    String spellIsOnCooldown = "Your spell is on cooldown! Wait for the next round."; // TEMPORARY VARIABLE

    public final void receiveSpell(Description description) {
        int relativeArmor = (int) ((armor * (1 - description.armorPen * 0.01)) / 2);
        int relativeMR = (int) ((magicResist * (1 - description.magicPen * 0.01)) / 2);
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
        if (!isSpellOnCooldown(cooldown[0]) && currentActionPoints >= costQ) {
            setOnCooldown(0);
            Spell spellQ = provideQ(enemy);
            voiceHandler.playQSound();
            currentActionPoints = currentActionPoints - spellQ.actionPointsCost;
            return spellQ.description;
        } else {
            System.out.println(spellIsOnCooldown);
            return new Description();
        }
    }

    public final Description useW(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[1]) && currentActionPoints >= costW) {
            setOnCooldown(1);
            Spell spellW = provideW(enemy);
            voiceHandler.playWSound();
            currentActionPoints = currentActionPoints - spellW.actionPointsCost;
            return spellW.description;
        } else {
            System.out.println(spellIsOnCooldown);
            return new Description();
        }
    }

    public final Description useE(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[2]) && currentActionPoints >= costE) {
            voiceHandler.playESound();
            Spell spellE = provideE(enemy);
            currentActionPoints = currentActionPoints - spellE.actionPointsCost;
            setOnCooldown(2);
            return spellE.description;
        } else {
            System.out.println(spellIsOnCooldown);
            return new Description();
        }
    }

    public final Description useR(Enemy enemy) {
        if (!isSpellOnCooldown(cooldown[3]) && currentActionPoints >= costR) {
            voiceHandler.playRSound();
            Spell spellR = provideR(enemy);
            currentActionPoints = currentActionPoints - spellR.actionPointsCost;
            setOnCooldown(3);
            return spellR.description;
        } else {
            System.out.println(spellIsOnCooldown);
            return new Description();
        }
    }

    public final Description usePassive(Enemy enemy) {
        Spell spellPassive = providePassive(enemy);
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

    protected void resetTheCooldown(int spellNumber) {
        cooldown[spellNumber] = false;
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
    public int getHpPercentage() {
        return (int) hp / maxHP;
    }
}
