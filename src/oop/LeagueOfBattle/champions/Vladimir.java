package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellListener;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

public class Vladimir extends Champion {

    private final String VLADIMIR = "Vladimir";

    public Vladimir(ChampionVoiceLineHandler voiceHandler, SubtitlesPrinter subtitlesPrinter) {
        super(voiceHandler, subtitlesPrinter);
        name = VLADIMIR;
        maxHP = 300;
        currentHp = 300;
        armor = 20;
        magicResist = 20;
        abilityPower = 40;
        attackDimig = 10;
        actionPoints = 4;
        armorPenetration = 0;
        currentActionPoints = actionPoints;
        //   costQ = 2;
        //      costW = 1;
        //     costE = 2;
        //    costR = actionPoints;
        isAssassin = false;
    }

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
            spellQ = new Spell(new Description(0, 0, abilityPower * 2, false, 0, 0, false), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    int hpCost = (int) (0.05 * currentHp);
                    currentHp = currentHp - hpCost;
                    subtitlesPrinter.vladimirUsedBlood(hpCost);
                    int absoluteDamageDealt = 2 * abilityPower;
                    int damageHealed = (int) (absoluteDamageDealt * 0.1);
                    currentHp = currentHp + damageHealed;
                    subtitlesPrinter.vladimirHealed(damageHealed);
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
                    int hpGain = (int) (abilityPower * 0.1);
                    abilityPower = abilityPower - 5;
                    currentHp = currentHp + hpGain;
                    subtitlesPrinter.vladimirExchange(5, hpGain);
                }
            });
        }
        return spellW;
    }

    @Override
    public Spell provideE() {
        if (spellE == null) {
            spellE = new Spell(new Description(), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    int hpCost = (int) (maxHP * 0.05);
                    currentHp = currentHp - hpCost;
                    subtitlesPrinter.vladimirUsedBlood(hpCost);
                    if (currentHp < maxHP * 0.1) {
                        abilityPower = abilityPower + 20;
                        subtitlesPrinter.vladimirGainedAp(20, abilityPower);
                    } else if (currentHp < maxHP * 0.3) {
                        abilityPower = abilityPower + 13;
                        subtitlesPrinter.vladimirGainedAp(13, abilityPower);
                    } else if (currentHp < maxHP * 0.5) {
                        abilityPower = abilityPower + 9;
                        subtitlesPrinter.vladimirGainedAp(9, abilityPower);
                    } else if (currentHp < maxHP * 0.7) {
                        abilityPower = abilityPower + 5;
                        subtitlesPrinter.vladimirGainedAp(5, abilityPower);
                    } else if (currentHp < maxHP * 0.8) {
                        abilityPower = abilityPower + 3;
                        subtitlesPrinter.vladimirGainedAp(3, abilityPower);
                    } else if (currentHp > maxHP * 0.8) {
                        abilityPower = abilityPower + 1;
                        subtitlesPrinter.vladimirGainedAp(1, abilityPower);
                    }

                }
            });
        }
        return spellE;
    }

    @Override
    public Spell provideR() {
        if (spellR == null) {
            final int[] rDamage = {0};
            spellR = new Spell(new Description(0, 0, rDamage[0], false, 0, 0, false), 4, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    if(abilityPower>150){
                        abilityPower =abilityPower - 100;
                        currentHp = currentHp + 100;
                        rDamage[0] = 50;
                    }else{
                        subtitlesPrinter.vladimirNotEnoughAp();
                    }
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
                    if (maxHP * 0.5 >= currentHp) {
                        abilityPower = abilityPower + 10;
                        subtitlesPrinter.vladimirPrintPassiveGainedAp(abilityPower);
                    } else {
                        currentHp = currentHp - 20;
                        subtitlesPrinter.vladimirPrintPassiveLostBlood();
                    }
                }
            });
        }
        return passive;
    }
}
/*   @Override
    public void spellQ(Champion champion) {
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {

                champion.getDamage(attackDimig * 2,champion.getArmor());
                hp = hp + damageHealed;
                System.out.println(damageHealed);

                currentActionPoints = currentActionPoints - 2;
                if (MathHelper.randomInt(1,2) == 1) {
                    soundHandler.playSound(RengarSounds.Q1);
                } else {
                    soundHandler.playSound(RengarSounds.Q2);
                }
                isSpellOnCooldown[0] = true;
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }
    @Override
    public void passiveSpell() {
        if(maxHP*0.5 >= hp){
            attackDimig = attackDimig + 10;
            System.out.println("Crimson Pact: Vladimir gained 10 AP. Current AP: " + attackDimig);
        }
        else{
            hp = hp - 20;
            System.out.println("Crimson Pact: Vladimir lost 20 blood.");
        }
    }

}
*/
