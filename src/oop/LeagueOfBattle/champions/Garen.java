package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.voiceLines.Garen.GarenSounds;

public class Garen extends Champion {
    public Garen() {
        name = "Garen";
        maxHP = 400;
        hp = 400;
        armor = 40;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 20;
        actionPoints = 4;
        currentActionPoints = actionPoints;
        //     isSpellOnCooldown = new boolean[3];
        //   isUltimateOnCooldown = true;
        // ultimateCooldown = 5;
        soundPath = "src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\PickGaren.wav\\";
        isAssasin = false;
    }


    // champion.getTrueDamage((float) (5 + ((maxHP - hp) * 0.15)));


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
    @Override
    public Description useQ(Enemy enemy) {
        return new Description(0, attackDimig * 3, 0, 0, 0, 0, false);
    }

    @Override
    public Description useW(Enemy enemy) {
        return null;
    }

    @Override
    public Description useE(Enemy enemy) {
        return null;
    }

    @Override
    public Description useR(Enemy enemy) {
        int enemyHpPercentage = enemy.getHpPercentage();
        return new Description();
    }

    @Override
    public Description useW() {
        armor = armor + 2;
        magicResist = magicResist + 2;
        return new Description();
    }

    @Override
    public Description useE() {
        int spins = MathHelper.randomInt(0, 13);
        int spinsDamage = 15;
        for (int i = 1; i <= spins; i++) {
            spinsDamage = spinsDamage + 7;
        }
        return new Description(0, spinsDamage, 0, 0, 0, 0, false);
    }

    @Override
    public Description useR() {
        int dimigDealt = (int) (5 + ((maxHP - hp) * 0.15));
        return new Description();
    }

}

