package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;

public class Vladimir extends Champion {

    private final String VLADIMIR = "Vladimir";

    public Vladimir(ChampionVoiceLineHandler voiceHandler) {
        super(voiceHandler);
        name = VLADIMIR;
        maxHP = 300;
        hp = 300;
        armor = 20;
        magicResist = 20;
        abilityPower = 40;
        attackDimig = 10;
        actionPoints = 4;
        armorPenetration = 0;
        currentActionPoints = actionPoints;
        costQ = 2;
        costW = 1;
        costE = 2;
        costR = actionPoints;
        isAssassin = false;
    }

    @Override
    public Spell provideAA(Enemy enemy) {
        Description AA = new Description(0, attackDimig, 0, 0, 0, 0, false);
        return new Spell(AA, 1);
    }

    @Override
    public Spell provideQ(Enemy enemy) {
        return new Spell(new Description(), 2);
    }

    @Override
    public Spell provideW(Enemy enemy) {
        return new Spell(new Description(), 2);
    }

    @Override
    public Spell provideE(Enemy enemy) {
        return new Spell(new Description(), 2);
    }

    @Override
    public Spell provideR(Enemy enemy) {
        return new Spell(new Description(), 2);
    }

    @Override
    public Spell providePassive(Enemy enemy) {
        return null;
    }
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

}
*/
