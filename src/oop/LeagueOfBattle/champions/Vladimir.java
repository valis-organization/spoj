package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;

public class Vladimir extends Champion {
    private final String NAME = "Vladimir";

    public Vladimir() {
        name = NAME;
        maxHP = 300;
        hp = 300;
        armor = 20;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 40;
        actionPoints = 4;
        currentActionPoints = actionPoints;
        isAssasin = false;
    }

    @Override
    public Description useQ(Enemy enemy) {
        return null;
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
        return null;
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
*/
}

