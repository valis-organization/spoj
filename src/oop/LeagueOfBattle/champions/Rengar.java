package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Hero;

public class Rengar extends Hero {

    public Rengar() {
        name = "Rengar";
        hp = 50;
        armor = 10;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 80;
        actionPoints = 4;
        currentActionPoints = actionPoints;
        isSpellOnCooldown = new boolean[3];
    }

    @Override
    public void getDemage(float attackDimig) {
        hp = hp - (attackDimig / (armor / 2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig / (armor / 2) + " demage.");
    }

    @Override
    public void basicAttack(Hero hero) {
        hero.getDemage(attackDimig);
        currentActionPoints--;
    }

    @Override
    public void spellQ(Hero hero) {
        //Basic attack with MORE damage
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {

                hero.getDemage((float) (attackDimig * 2));
                currentActionPoints = currentActionPoints - 2;
                isSpellOnCooldown[0] = true;
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void spellW() {
        //Rengar heals for x (from 0 to 21) hp, and has 40% chances for it
        int randomNum = (int) (Math.random() * 5);
        int healedHp = (int) (Math.random() * 21);

        if (randomNum == 0 || randomNum == 1) {
            hp = hp + healedHp;
            System.out.println("Successfully healed for: " + healedHp + "hp, Your current hp is: " + hp);
        } else {
            System.out.println("You did not heal yourself");
        }
        currentActionPoints--;

    }

    @Override
    public void spellE(Hero hero) {
        hero.getDemage((float) (attackDimig * 0.9));
        this.currentActionPoints = this.currentActionPoints - 2;
        hero.currentActionPoints--;
    }

    @Override
    public void ultimateSpell() {

    }

    @Override
    public void passiveSpell() {

    }

}
