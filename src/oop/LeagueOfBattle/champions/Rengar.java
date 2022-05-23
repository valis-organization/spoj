package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellListener;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

public class Rengar extends Champion {
    private final String NAME = "Rengar";

    public Rengar(ChampionVoiceLineHandler rengarVoiceHandler, SubtitlesPrinter subtitlesPrinter) {
        super(rengarVoiceHandler, subtitlesPrinter);
        name = NAME;
        maxHP = 200;
        currentHp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 50;
        actionPoints = 4;
        armorPenetration = 20;
        currentActionPoints = actionPoints;
        // costQ = 2;
        //costW = 1;
        // costE = 2;
        // costR = actionPoints;
        isAssassin = true;
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
            spellQ = new Spell(new Description(0, attackDimig * 3, 0, false, armorPenetration, 0, false), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
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
                    int healedHp = MathHelper.randomInt(0, 21);
                    if ((MathHelper.randomInt(1, 2) == 1)) {
                        currentHp = currentHp + healedHp;
                        subtitlesPrinter.rengarSuccessfulHeal(healedHp, currentHp);
                    } else {
                        subtitlesPrinter.rengarUnSuccessfulHeal();
                    }
                }
            });
        }
        return spellW;
    }

    @Override
    public Spell provideE() {
        if (spellE == null) {
            spellE = new Spell(new Description(1, (int) (attackDimig * 0.5), 0, false, 0, 0, false), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
                }
            });
        }
        return spellE;
    }

    @Override
    public Spell provideR() {
        if (aa == null) {
            aa = new Spell(new Description(), actionPoints, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    attackDimig = attackDimig + 20;
                    provideQ();
                    provideE();
                    provideW();
                    attackDimig = attackDimig - 20;
                }
            });
        }
        return aa;
    }

    @Override
    public Spell providePassive() {
        if (passive == null) {
            passive = new Spell(new Description(), 0, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    attackDimig = attackDimig + 5;
                    subtitlesPrinter.rengarPrintPassive();
                }
            });
        }
        return passive;
    }
    /*

    @Override
    public void ultimateSpell(Champion champion) {
        //rengar unleash his power
        if (currentActionPoints >= 3) {
            if (!isUltimateOnCooldown) {
                currentActionPoints = 10;
                attackDimig = attackDimig + 20;
                spellQ(champion);
                spellW();
                spellE(champion);
                currentActionPoints = 0;
                attackDimig = attackDimig - 20;
                isUltimateOnCooldown = true;
            } else {
            }
                System.out.println("Your spell is on cooldown!");
        } else {
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void passiveSpell() {
        //Bonetooth necklace: Rengar collets Thropies for his victims (every round +5 AD)
        attackDimig = attackDimig + 5;
        System.out.println("Bonetooth necklace: Rengar got +5 AD");
    }
*/
}
