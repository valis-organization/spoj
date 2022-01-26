package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;

public class Ryze extends Champion {
    private int randomVoice = 0; //todo code did not compile. eddit that value
    //todo btw it can be moved to other file
    public Ryze() {
        name = "Ryze";
        maxHP = 100;
        hp = 100;
        armor = 10;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 50;
        actionPoints = 4;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        isSpellOnCooldown = new boolean[3];
        isUltimateOnCooldown = true;
        ultimateCooldown = 4;
        soundPath = "sciezka";
        assasin = false;
    }

    boolean isMarked = false;

    @Override
    public void getDamage(float attackDimig, float armor) {
        hp = hp - attackDimig;
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig + " True damage.");
    }

    @Override
    public void getTrueDamage(float attackDimig) {
        hp = hp - attackDimig;
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig + " True damage.");
    }

    @Override
    public void basicAttack(Champion champion) {
        champion.getDamage(attackDimig, champion.getArmor());
        currentActionPoints--;
    }

    @Override
    public void spellQ(Champion champion) {
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 1) {
                if (isMarked) {
                    champion.getDamage((float) (attackDimig * 3), champion.getArmor());
                } else {
                    champion.getDamage((float) (attackDimig * 1.5), champion.getArmor());
                }
                currentActionPoints--;
                isSpellOnCooldown[0] = true;

                if (randomVoice == 1) {
                    soundHandler.playSound("C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\Ryze\\ryzeQ1.wav");
                } else {
                    soundHandler.playSound("C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\Ryze\\ryzeQ2.wav");
                }
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void spellW() {

    }

    @Override
    public void spellE(Champion champion) {
        //Marking enemy
        if (!isSpellOnCooldown[1]) {
            if (currentActionPoints >= 1) {
                    champion.getDamage((float) (attackDimig * 0.6), champion.getArmor());
                isMarked = true;
                currentActionPoints--;
                isSpellOnCooldown[1] = true;
                isSpellOnCooldown[0] = false;

                if (randomVoice == 1) {
                    soundHandler.playSound("C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\Ryze\\ryzeE1.wav");
                } else {
                    soundHandler.playSound("C:\\Users\\Dawid\\IdeaProjects\\zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\Ryze\\ryzeE2.wav");
                }
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void ultimateSpell(Champion champion) {

    }

    @Override
    public void passiveSpell() {

    }
}
