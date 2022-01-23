package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;

public class Rengar extends Champion {

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
        soundPath = "C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\PickRengar.wav";
    }

    @Override
    public void getDemage(float attackDimig) {
        hp = hp - (attackDimig / (armor / 2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig / (armor / 2) + " demage.");
    }

    @Override
    public void basicAttack(Champion champion) {
        champion.getDemage(attackDimig);
        currentActionPoints--;
    }

    @Override
    public void spellQ(Champion champion) {
        //Basic attack with MORE damage
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {

                champion.getDemage((float) (attackDimig * 2));
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
    public void spellE(Champion champion) {
        champion.getDemage((float) (attackDimig * 0.9));
        this.currentActionPoints = this.currentActionPoints - 2;
        champion.currentActionPoints--;
    }

    @Override
    public void ultimateSpell() {

    }

    @Override
    public void passiveSpell() {

    }

}
