package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

public class Rengar extends Champion {
    ChampionVoiceLineHandler rengarVoiceHandler;
    public Rengar(ChampionVoiceLineHandler rengarVoiceHandler) {
        name = "Rengar";
        maxHP = 200;
        hp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 50;
        actionPoints = 4;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        //      isSpellOnCooldown = new boolean[3];
        //     isUltimateOnCooldown = true;
        //   ultimateCooldown = 4;
        isAssasin = true;
        this.rengarVoiceHandler = rengarVoiceHandler;
    }

    @Override
    public Description useQ(Enemy enemy) {
        rengarVoiceHandler.playQSound();
        Description description = new Description(0, attackDimig * 3, 0, 0, armorPenetration, 0, false);
        return description;
    }

    @Override
    public Description useW(Enemy enemy) {
        rengarVoiceHandler.playWSound();
        return new Description();
    }

    @Override
    public Description useE(Enemy enemy) {
        rengarVoiceHandler.playESound();
        Description description = new Description(1, (int) (attackDimig * 0.9), 0, 0, 0, 0, false);
        return description;
    }

    @Override
    public Description useR(Enemy enemy) {
        attackDimig = attackDimig + 20;
        useQ(enemy);
        useW(enemy);
        useE(enemy);
        attackDimig = attackDimig - 20;
        return new Description();
    }
    /*

    @Override
    public void spellW() {
        //Rengar heals for x (from 0 to 21) hp, and has 40% chances for it
        int randomNum = MathHelper.randomInt(1,5);
        int healedHp =  MathHelper.randomInt(0,21);

        if (randomNum == 1 || randomNum == 2) {
            hp = hp + healedHp;
            System.out.println("Successfully healed for: " + healedHp + "hp, Your current hp is: " + hp);
            if (MathHelper.randomInt(1,2) == 1) {
                soundHandler.playSound(RengarSounds.W1);
            } else {
                soundHandler.playSound(RengarSounds.W2);
            }
        } else {
            System.out.println("You did not heal yourself");
        }
        currentActionPoints--;
    }


    @Override
    public void ultimateSpell(Champion champion) {
        //rengar unleash his power
        if (currentActionPoints >= 3) {
            if (!isUltimateOnCooldown) {
                currentActionPoints = 10;
                attackDimig = attackDimig + 20;
                spellQ(champion);
                spellW();
                spellE(champion);
                currentActionPoints = 0;
                attackDimig = attackDimig - 20;
                isUltimateOnCooldown = true;
            } else {
            }
                System.out.println("Your spell is on cooldown!");
        } else {
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void passiveSpell() {
        //Bonetooth necklace: Rengar collets Thropies for his victims (every round +5 AD)
        attackDimig = attackDimig + 5;
        System.out.println("Bonetooth necklace: Rengar got +5 AD");
    }
*/
}
