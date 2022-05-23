package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellListener;
import oop.LeagueOfBattle.champions.base.spell.SpellProvider;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;


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
   // protected boolean[] cooldown = new boolean[4];
    protected Spell aa;
    protected Spell spellQ;
    protected Spell spellW;
    protected Spell spellE;
    protected Spell spellR;
    protected Spell passive;

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
        if (description.damageByMissingHp && description.trueDmg) {
            int damageByMissingHp = (int) (description.adDmg * (1.1 - getHpPercentage()));
            this.currentHp = currentHp - damageByMissingHp;
        } else if (description.damageByMissingHp) {
            int adDamageByMissingHp = (int) (description.adDmg * (1.1 - getHpPercentage()));
            this.currentHp = currentHp - adDamageByMissingHp / relativeArmor;
            this.currentHp = currentHp - description.apDmg / relativeMR;
        } else {
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

    public Spell aaHandler() {
        Spell AA = provideAA();
        currentActionPoints = currentActionPoints - AA.actionPointsCost;
        return AA;
    }

    public final Spell spellQHandler() {
        Spell spellQ = provideQ();
        if (!spellQ.isSpellOnCooldown && currentActionPoints >= spellQ.actionPointsCost) {
            voiceHandler.playQSound();
            currentActionPoints = currentActionPoints - spellQ.actionPointsCost;
            spellQ.isSpellOnCooldown = true;
            return spellQ;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
    }

    public final Spell spellWHandler() {
        Spell spellW = provideW();
        if (!spellW.isSpellOnCooldown && currentActionPoints >= spellW.actionPointsCost) {
            voiceHandler.playWSound();
            currentActionPoints = currentActionPoints - spellW.actionPointsCost;
            spellW.isSpellOnCooldown = true;
            return spellW;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
    }

    public final Spell spellEHandler() {
        Spell spellE = provideE();
        if (!spellE.isSpellOnCooldown && currentActionPoints >= spellE.actionPointsCost) {
            voiceHandler.playESound();
            currentActionPoints = currentActionPoints - spellE.actionPointsCost;
            spellE.isSpellOnCooldown = true;
            return spellE;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
    }

    public final Spell spellRHandler() {
        Spell spellR = provideR();
        if (!spellR.isSpellOnCooldown && currentActionPoints >= spellR.actionPointsCost) {
            voiceHandler.playRSound();
            currentActionPoints = currentActionPoints - spellR.actionPointsCost;
            spellR.isSpellOnCooldown = true;
            return spellR;
        } else {
            subtitlesPrinter.spellOnCooldown();
            return new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
    }

   // public final Description usePassive() {
   //     Spell spellPassive = providePassive();
   //     return new Description();
   // }

    protected boolean isSpellOnCooldown(boolean whichSpell) {
        return whichSpell;
    }

    //reset
    public final void resetCurrentActionPoints() { //
        currentActionPoints = actionPoints;
    }

    //cooldowns
    public final void resetCooldowns() {
        if (spellQ != null) {
            spellQ.isSpellOnCooldown = false;
        }
        if (spellW != null) {
            spellW.isSpellOnCooldown = false;
        }
        if (spellE != null) {
            spellE.isSpellOnCooldown = false;
        }
        if (spellR != null) {
            spellR.isSpellOnCooldown = false;
        }
    }

    protected void setOnCooldown(Spell spell) {
        if(spell !=null) {
            spell.isSpellOnCooldown = false;
        }
    }

    protected void resetCooldown(Spell spell) {
        if(spell !=null) {
            spell.isSpellOnCooldown = false;
        }
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
