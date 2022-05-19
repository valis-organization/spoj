package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
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
        Description AA = new Description(0, attackDimig, 0, false, 0, 0, false);
        return new Spell(AA, 1);
    }

    @Override
    public Spell provideQ() {
        Description spellQ = new Description(0, attackDimig * 3, 0, false, 0, 0, false);
        return new Spell(spellQ, 2);
    }

    @Override
    public Spell provideW() {
        armor = armor + 2;
        magicResist = magicResist + 2;
        return new Spell(new Description(), 1);
    }

    @Override
    public Spell provideE() {

        int spins = MathHelper.randomInt(0, 13);
        int spinsDamage = 15;
        subtitlesPrinter.garenPrintSpinsCount(spins);
        for (int i = 1; i <= spins; i++) {
            spinsDamage = spinsDamage + 7;
        }
        Description spellE = new Description(0, spinsDamage, 0, false, 0, 0, false);
        return new Spell(spellE, 2);
    }

    @Override
    public Spell provideR() {
       // int enemyHpPercentage = enemy.getHpPercentage();
        int damageDealt = (int) 50; //* (1.1 - enemyHpPercentage));
        Description spellR = new Description(0, damageDealt, 0, true, 0, 0, true);
        return new Spell(spellR, actionPoints);
    }

    @Override
    public Spell providePassive() {
        int minHpToGetPassive = maxHP - 30;
        if (currentHp <= minHpToGetPassive) {
            int regeneratedHp = (int) ((maxHP - currentHp) * 0.035);
            currentHp = (currentHp + regeneratedHp);
            subtitlesPrinter.garenPrintPassive(regeneratedHp);
        }
        armor++;
        return new Spell(new Description(), 0);
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