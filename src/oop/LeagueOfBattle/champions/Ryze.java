package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.voiceLines.ryze.RyzeSounds;

public class Ryze extends Champion {
    public Ryze() {
        name = "Ryze";
        maxHP = 200;
        hp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 50;
        attackDimig = 10;
        actionPoints = 5;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        soundPath = RyzeSounds.Pick;
        isAssasin = false;
    }

    boolean isMarked = false;

    @Override
    public Description useQ(Enemy enemy) {
        if(isMarked){
            isMarked = false;
            return new Description(0,0, (int) (abilityPower*3),0,0,0,false);
        }else {
            return new Description(0,0, (int) (abilityPower*1.5),0,0,0,false);
        }
        //todo resets E cooldown
    }

    @Override
    public Description useW(Enemy enemy) {
        int random = MathHelper.randomInt(1, 6);
        if (random == 1) {
            abilityPower = abilityPower + 5;
            soundHandler.playSound(RyzeSounds.W1);
            System.out.println("Ryze gained 5 AP");
        } else if (random == 2) {
            // resets Q cooldown
            soundHandler.playSound(RyzeSounds.W2);
            System.out.println("Ryze: Q COOLDOWN HAS BEEN RESET!");
        } else if (random == 3) {
           // resets W cooldown
            soundHandler.playSound(RyzeSounds.W3);
            System.out.println("Ryze: W COOLDOWN HAS BEEN RESET!");
        } else if (random == 4) {
            // resets E cooldown
            soundHandler.playSound(RyzeSounds.W4);
            currentActionPoints++;
            System.out.println("Ryze: E COOLDOWN HAS BEEN RESET! Gained 1 action point");
        } else if (random == 5) {
            currentActionPoints++;
            System.out.println("Ryze: Gained 1 action points");
        } else if (random == 6) {
            System.out.println("The scroll has burned out. Nothing happens.");
        }
        return new Description();
    }

    @Override
    public Description useE(Enemy enemy) {
        isMarked = true;
        //todo resets Q cooldown
        return new Description(0,0, (int) (abilityPower*0.6),0,0,0,false);
    }

    @Override
    public Description useR(Enemy enemy) {
        //todo gains 5 ActionPoints or come up with new idea
        return null;
    }
}
