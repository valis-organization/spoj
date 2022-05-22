package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.champions.base.spell.SpellListener;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

public class Garen extends Champion {

    private final String GAREN = "Garen";

    public Garen(ChampionVoiceLineHandler garenVoiceHandler, SubtitlesPrinter subtitlesPrinter) {
        super(garenVoiceHandler, subtitlesPrinter);
        name = GAREN;
        maxHP = 400;
        currentHp = 400;
        armor = 40;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 20;
        actionPoints = 4;
        armorPenetration = 0;
        currentActionPoints = actionPoints;
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
            spellQ = new Spell(new Description(0, attackDimig * 3, 0, false, 0, 0, false), 2, new SpellListener() {
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
                    armor = armor + 2;
                    magicResist = magicResist + 2;
                }
            });
        }
        return spellW;
    }

    @Override
    public Spell provideE() {
        if (spellE == null) {
            final int[] spinsDamage = {15};
            spellE = new Spell(new Description(0, spinsDamage[0], 0, false, 0, 0, false), 2, new SpellListener() {
                @Override
                public void onSpellUsed() {
                    int spins = MathHelper.randomInt(0, 13);
                    subtitlesPrinter.garenPrintSpinsCount(spins);
                    for (int i = 1; i <= spins; i++) {
                        spinsDamage[0] = spinsDamage[0] + 7;
                    }

                }
            });
        }
        return spellE;
    }

    @Override
    public Spell provideR() {
        if (spellR == null) {
            spellR = new Spell(new Description(0, 50, 0, true, 0, 0, true), actionPoints, new SpellListener() {
                @Override
                public void onSpellUsed() {
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
                    int minHpToGetPassive = maxHP - 30;
                    if (currentHp <= minHpToGetPassive) {
                        int regeneratedHp = (int) ((maxHP - currentHp) * 0.035);
                        currentHp = (currentHp + regeneratedHp);
                        subtitlesPrinter.garenPrintPassive(regeneratedHp);
                    }
                    armor++;
                }
            });
        }
        return passive;
    }

   /* @Override
    public Description useR() {
        int dimigDealt = (int) (5 + ((maxHP - hp) * 0.15));
        return new Description();
    }
*/
}


    /* @Override
     public void passiveSpell() {
         //Perseverance: Garen regeneraters 3.5% of his hp every round. He also gains 2 armor.
         if (hp != maxHP) {
             hp = (float) (hp + ((maxHP - hp) * 0.035));
             System.out.println("Perseverance: Garen regenerated " + ((maxHP - hp) * 0.035) + " hp.");
         }
         armor++;
     }


  */

    /* @Override
         public Description useQ(Enemy enemy) {
             garenVoiceHandler.playQSound();
             return provideQ(enemy).description;
         }

         @Override
         public Description useW(Enemy enemy) {
             garenVoiceHandler.playWSound();
             armor = armor + 2;
             magicResist = magicResist + 2;
             return new Description();
         }

         @Override
         public Description useE(Enemy enemy) {
             garenVoiceHandler.playESound();
             int spins = MathHelper.randomInt(0, 13);
             int spinsDamage = 15;
             for (int i = 1; i <= spins; i++) {
                 spinsDamage = spinsDamage + 7;
             }
             return new Description(0, spinsDamage, 0, 0, 0, 0, false);
         }

         @Override
         public Description useR(Enemy enemy) {
             garenVoiceHandler.playRSound();
             int enemyHpPercentage = enemy.getHpPercentage();
             int damageDealt = (int) (5 + enemyHpPercentage * 0.15);
             return new Description(0, damageDealt, 0, 0, 0, 0, true);
         }
     */