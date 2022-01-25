package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.voiceLines.Garen.GarenSounds;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

public class Garen extends Champion {
    public Garen() {
        name = "Garen";
        maxHP = 200;
        hp = 200;
        armor = 20;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 20;
        actionPoints = 4;
        currentActionPoints = actionPoints;
        isSpellOnCooldown = new boolean[3];
        isUltimateOnCooldown = true;
        ultimateCooldown = 5;
        soundPath = "zadanie\\src\\oop\\LeagueOfBattle\\voiceLines\\Garen\\PickGaren.wav";
        assasin = false;
    }

    @Override
    public void getTrueDamage(float attackDimig) {
        hp = hp - attackDimig;
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig + " True damage.");
    }

    @Override
    public void getDamage(float attackDimig, float armor) {
        hp = hp - (attackDimig / (armor / 2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig / (armor / 2) + " damage.");
    }

    @Override
    public void basicAttack(Champion champion) {
        champion.getDamage(attackDimig, champion.getArmor());
        currentActionPoints--;
    }

    @Override
    public void spellQ(Champion champion) {
        //Garen deals damage (3x his base ad)
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {
                champion.getDamage(attackDimig * 3, champion.getArmor());
                currentActionPoints = currentActionPoints - 2;
                isSpellOnCooldown[0] = true;
                if (MathHelper.randomInt(0,1) == 1) {
                    soundHandler.playSound(GarenSounds.Q1);
                } else {
                    soundHandler.playSound(GarenSounds.Q2);
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
        //Adding amount of armor. (concept: TENACITY: Gains 1 action point, allows to use 1 spell and removes 2 action points)  - 1 Action Point
        armor = (float) (armor + 1.5);
        System.out.println("Increased your armor and MR! Now A: " + armor);
        if (MathHelper.randomInt(0,1) == 1) {
            soundHandler.playSound(GarenSounds.E1);
        } else {
            soundHandler.playSound(GarenSounds.E2);
        }
        currentActionPoints--;
    }

    @Override
    public void spellE(Champion champion) { //Garen can spin random amount of times. Spin deals 3 + (1 dmg*every spin)
        if (currentActionPoints >= 2) {
            int spins = MathHelper.randomInt(0,13);
            float spinsDamage = 15;
            System.out.println(spins);
            for (int i = 1; i <= spins; i++) {
                spinsDamage = spinsDamage + 7;
            }
            champion.getDamage(spinsDamage, champion.getArmor());
            currentActionPoints = currentActionPoints - 2;
            if (MathHelper.randomInt(0,1) == 1) {
                soundHandler.playSound(GarenSounds.E1);
            } else {
                soundHandler.playSound(GarenSounds.E2);
            }
        } else {
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void ultimateSpell(Champion champion) {
        if (currentActionPoints >= 3) {
            if (!isUltimateOnCooldown) {
                champion.getTrueDamage((float) (5 + ((maxHP - hp) * 0.30)));
                currentActionPoints = 0;
                if (MathHelper.randomInt(0,1) == 1) {
                    soundHandler.playSound(GarenSounds.R1);
                } else {
                    soundHandler.playSound(GarenSounds.R2);
                }
            } else {
                System.out.println("Your spell is on cooldown!");
            }
        } else {
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void passiveSpell() {
        //Perseverance: Garen regeneraters 7% of his hp every round. He also gains 2 armor.
        if (hp != maxHP) {
            hp = (float) (hp + ((maxHP - hp) * 0.07));
            System.out.println("Perseverance: Garen regenerated " + ((maxHP - hp) * 0.07) + " hp.");
        }
        armor++;
    }

}
