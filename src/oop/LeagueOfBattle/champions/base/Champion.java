package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellProvider;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

import java.util.Arrays;


public abstract class Champion implements SpellProvider {
    protected final SubtitlesPrinter subtitlesPrinter;
    public ChampionVoiceLineHandler voiceHandler;
    protected String name;
    //hp
    protected int maxHP;
    protected int currentHp;
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
    protected boolean[] cooldown = new boolean[4];

    protected boolean isAssassin;  //todo interface?

    public Champion(ChampionVoiceLineHandler voiceHandler, SubtitlesPrinter subtitlesPrinter) {
        this.voiceHandler = voiceHandler;
        this.subtitlesPrinter = subtitlesPrinter;
    }

    public final void receiveSpell(Description description) {
        int relativeArmor = (int) ((armor * (1 - description.armorPen * 0.01)) / 2);
        int relativeMR = (int) ((magicResist * (1 - description.magicPen * 0.01)) / 2);
        relativeArmor = relativeArmor == 0 ? 1 : relativeArmor;
        relativeMR = relativeMR == 0 ? 1 : relativeMR;
        if(description.damageByMissingHp && description.trueDmg) {
            int damageByMissingHp = (int) (description.adDmg * (1.1 - getHpPercentage()));
            this.currentHp = currentHp - damageByMissingHp;
        }else if(description.damageByMissingHp){
            int adDamageByMissingHp = (int) (description.adDmg * (1.1 - getHpPercentage()));
            this.currentHp = currentHp - adDamageByMissingHp / relativeArmor;
            this.currentHp = currentHp - description.apDmg / relativeMR;
        }else {
            if (description.trueDmg) {
                this.currentHp = currentHp - description.adDmg;
                this.currentHp = currentHp - description.apDmg;
            } else {
                this.currentHp = currentHp - description.adDmg / relativeArmor;
                this.currentHp = currentHp - description.apDmg / relativeMR;
            }
        }
        this.currentActionPoints = currentActionPoints - description.removedActionPoints;

    }

    public Description useAA() {
        Spell AA = provideAA();
        currentActionPoints = currentActionPoints - AA.actionPointsCost;
        return new Description();
    }

    public final Description useQ() {
        if (!isSpellOnCooldown(cooldown[0]) && currentActionPoints > 0) {
            setOnCooldown(0);
            Spell spellQ = provideQ();
            voiceHandler.playQSound();
            currentActionPoints = currentActionPoints - spellQ.actionPointsCost;
            return spellQ.description;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Description();
        }
    }

    public final Description useW() {
        if (!isSpellOnCooldown(cooldown[1]) && currentActionPoints > 0) {
            setOnCooldown(1);
            Spell spellW = provideW();
            voiceHandler.playWSound();
            currentActionPoints = currentActionPoints - spellW.actionPointsCost;
            return spellW.description;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Description();
        }
    }

    public final Description useE() {
        if (!isSpellOnCooldown(cooldown[2]) && currentActionPoints > 0) { //todo currentaction points >= spellcost
            voiceHandler.playESound();
            Spell spellE = provideE();
            currentActionPoints = currentActionPoints - spellE.actionPointsCost;
            setOnCooldown(2);
            return spellE.description;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Description();
        }
    }

    public final Description useR() {
        if (!isSpellOnCooldown(cooldown[3]) && currentActionPoints > 0) {
            voiceHandler.playRSound();
            Spell spellR = provideR();
            currentActionPoints = currentActionPoints - spellR.actionPointsCost;
            setOnCooldown(3);
            return spellR.description;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Description();
        }
    }

    public final Description usePassive() {
        Spell spellPassive = providePassive();
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
        return currentHp;
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
    private final int getHpPercentage() {
        return (int) currentHp / maxHP;
    }
}
