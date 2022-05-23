package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellListener;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

public class Ryze extends Champion {
    private final String RYZE = "Ryze";

    public Ryze(ChampionVoiceLineHandler ryzeVoiceHandler, SubtitlesPrinter subtitlesPrinter) {
        super(ryzeVoiceHandler, subtitlesPrinter);
        name = RYZE;
        maxHP = 200;
        currentHp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 50;
        attackDimig = 10;
        actionPoints = 3;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        //   costQ = 2;
        //   costW = 1;
        //   costE = = 1;
        //   costR = actionPoints;
        isAssassin = false;
    }

    boolean isMarked = false;

    @Override
    public Spell provideAA() {
        if (aa == null) {
            aa = new Spell(new Description(0, attackDimig, 0, false, 0, 0, false), 1, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
        return aa;
    }

    @Override
    public Spell provideQ() {
        if (spellQ == null) {
            final int[] qDamage = {(int) (abilityPower * 1.5)};
            spellQ = new Spell(new Description(0, 0, qDamage[0], false, 0, 0, false), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    if (isMarked) {
                        isMarked = false;
                        qDamage[0] = abilityPower * 4;
                    } else {
                        qDamage[0] = (int) abilityPower * 2;
                    }
                    if(spellE !=null) {
                        spellE.isSpellOnCooldown = false;
                    }
                }
            });
        }
        return spellQ;
    }

    @Override
    public Spell provideW() {
        if (spellW == null) {
            spellW = new Spell(new Description(), 1, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    int random = MathHelper.randomInt(1, 6);
                    if (random == 1) {
                        abilityPower = abilityPower + 5;
                        subtitlesPrinter.ryzeGainsAp();
                    } else if (random == 2) {
                        resetCooldown(spellQ);
                        subtitlesPrinter.ryzeResetQCooldown();
                    } else if (random == 3) {
                        resetCooldown(spellW);
                        subtitlesPrinter.ryzeResetWCooldown();
                    } else if (random == 4) {
                        resetCooldown(spellE);
                        currentActionPoints++;
                        subtitlesPrinter.ryzeResetECooldown();
                        subtitlesPrinter.ryzeGainsActionPoint();
                    } else if (random == 5) {
                        currentActionPoints++;
                        subtitlesPrinter.ryzeGainsActionPoint();
                    } else if (random == 6) {
                        subtitlesPrinter.ryzeBurnedScroll();
                    }
                }
            });
        }
        return spellW;
    }

    @Override
    public Spell provideE() {
        if (spellE == null) {
            spellE = new Spell(new Description(0, 0, (int) (abilityPower * 0.6), false, 0, 0, false), 1, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    isMarked = true;
                    resetCooldown(spellQ);
                }
            });
        }
        return spellE;
    }

    @Override
    public Spell provideR() {
        if (spellR == null) {
            spellR = new Spell(new Description(), actionPoints, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    actionPoints++;
                }
            });
        }
        return spellR;

    }

    @Override
    public Spell providePassive() {
        if (passive == null) {
            passive = new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    int gainedAp = MathHelper.randomInt(1, 5);
                    abilityPower = abilityPower + gainedAp;
                    subtitlesPrinter.ryzePrintPassive(gainedAp);
                }
            });
        }
        return passive;
    }
}

/*
    @Override
    public Description useR(Enemy enemy) {
        //todo gains 5 ActionPoints or come up with new idea
        return null;

}
*/