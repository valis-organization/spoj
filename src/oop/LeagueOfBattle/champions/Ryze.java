package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.voiceLines.ryze.RyzeSounds;

public class Ryze extends Champion {
    private int randomVoice = 0; //todo code did not compile. eddit that value
    //todo btw it can be moved to other file
    public Ryze() {
        name = "Ryze";
        maxHP = 200;
        hp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 50;
        actionPoints = 5;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        isSpellOnCooldown = new boolean[3];
        isUltimateOnCooldown = true;
        ultimateCooldown = 4;
        soundPath = RyzeSounds.Pick;
        assasin = false;
    }

    boolean isMarked = false;

    @Override
    public void getDamage(float attackDimig, float armor) {
        hp = hp - (attackDimig / (armor / 2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + (attackDimig / (armor / 2)) + " damage.");
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
                    isMarked = false;
                    if (MathHelper.randomInt(1, 2) == 1) {
                        soundHandler.playSound(RyzeSounds.MQ1);
                    } else {
                        soundHandler.playSound(RyzeSounds.MQ2);
                    }
                } else {
                    champion.getDamage((float) (attackDimig * 1.5), champion.getArmor());
                    if (MathHelper.randomInt(1, 2) == 1) {
                        soundHandler.playSound(RyzeSounds.Q1);
                    } else {
                        soundHandler.playSound(RyzeSounds.Q2);
                    }
                }
                currentActionPoints--;
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
        if (!isSpellOnCooldown[1]) {
            if (currentActionPoints >= 1) {
                int random = MathHelper.randomInt(1, 6);
                isSpellOnCooldown[1] = true;
                if (random == 1) {
                    attackDimig = attackDimig + 5;
                    soundHandler.playSound(RyzeSounds.W1);
                    System.out.println("Ryze gained 5 AP");
                } else if (random == 2) {
                    isSpellOnCooldown[0] = false; // resets Q cooldown
                    soundHandler.playSound(RyzeSounds.W2);
                    System.out.println("Ryze: Q COOLDOWN HAS BEEN RESET!");
                } else if (random == 3) {
                    isSpellOnCooldown[1] = false; // resets W cooldown
                    soundHandler.playSound(RyzeSounds.W3);
                    System.out.println("Ryze: W COOLDOWN HAS BEEN RESET!");
                } else if (random == 4) {
                    isSpellOnCooldown[2] = false; // resets E cooldown
                    soundHandler.playSound(RyzeSounds.W4);
                    currentActionPoints++;
                    System.out.println("Ryze: E COOLDOWN HAS BEEN RESET! Gained 1 action point");
                } else if (random == 5) {
                    currentActionPoints++;
                    System.out.println("Ryze: Gained 1 action points");
                } else if (random == 6) {
                    System.out.println("The scroll has burned out. Nothing happens.");
                }
                currentActionPoints--;
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void spellE(Champion champion) {
        //Marking enemy
        if (!isSpellOnCooldown[2]) {
            if (currentActionPoints >= 1) {
                champion.getDamage((float) (attackDimig * 0.6), champion.getArmor());
                isMarked = true;
                currentActionPoints--;
                isSpellOnCooldown[2] = true;
                isSpellOnCooldown[0] = false;
                System.out.println("Ryze: Q COOLDOWN HAS BEEN RESET");
                soundHandler.playSound(RyzeSounds.E1);
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void ultimateSpell(Champion champion) {
        if (currentActionPoints >= 1) {
            if (!isUltimateOnCooldown) {
                resetCooldowns();
                currentActionPoints = 5;
                soundHandler.playSound(RyzeSounds.R1);
            }else{
                    System.out.println("Your spell is on cooldown!");
            }
        }else{
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void passiveSpell() {

    }
}
