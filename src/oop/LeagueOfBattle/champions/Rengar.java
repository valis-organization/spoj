package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Spell;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.voiceLines.Rengar.RengarSounds;

import java.util.List;

public class Rengar extends Champion {

    public Rengar() {
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
        isSpellOnCooldown = new boolean[3];
        isUltimateOnCooldown = true;
        ultimateCooldown = 4;
        soundPath = RengarSounds.Pick;
        isAssasin = true;
    }

    @Override
    public void getDamage(float attackDimig, float armor) {
        hp = hp - (attackDimig / (armor / 2));//todo why devide by 2?
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig / (armor / 2) + " damage.");
    }

    @Override
    public void receiveSpell(Spell.Details spell) {
        hp = hp - spell.trueDmg;

        float relativeArmor = (armor - (armor * spell.armorPen));
        hp = hp - spell.addDmg / relativeArmor != 0 ? relativeArmor : 1;

        float relativeMr = (magicResist - (magicResist * spell.magicPen));
        hp = hp - spell.apDmg / relativeMr != 0 ? relativeMr : 1;
    }

    @Override
    public Spell.Details useSpeelQ() {
        return null;
    }

    @Override
    public List<Spell> usableSpells() {
        return null;
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
        //Basic attack with MORE damage
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {
                champion.getDamage(attackDimig * 3, (float) (champion.getArmor() - (armorPenetration * 0.1)));
                currentActionPoints = currentActionPoints - 2;
                if (MathHelper.randomInt(1,2) == 1) {//todo extract to other class
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
    public void spellE(Champion champion) {
        if (!isSpellOnCooldown[2]) {
            if (currentActionPoints >= 2) {
                champion.getDamage((float) (attackDimig * 0.9), getArmor());
                this.currentActionPoints = this.currentActionPoints - 2;
                if (MathHelper.randomInt(1,2) == 1) {
                    soundHandler.playSound(RengarSounds.E1);
                } else {
                    soundHandler.playSound(RengarSounds.E2);
                }
                champion.currentActionPoints--;
                isSpellOnCooldown[2] = true;
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
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

}
