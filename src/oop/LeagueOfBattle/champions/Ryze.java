package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;

public class Ryze extends Champion {
    private final String RYZE = "Ryze";

    public Ryze(ChampionVoiceLineHandler ryzeVoiceHandler) {
        super(ryzeVoiceHandler);
        name = RYZE;
        maxHP = 200;
        hp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 50;
        attackDimig = 10;
        actionPoints = 5;
        armorPenetration = 10;
        currentActionPoints = actionPoints;
        isAssassin = false;
    }

    boolean isMarked = false;

    @Override
    public Spell provideAA(Enemy enemy) {
        Description AA = new Description(0, attackDimig, 0, 0, 0, 0, false);
        return new Spell(AA, 1);
    }

    @Override
    public Spell provideQ(Enemy enemy) {
        Description spellQ;
        resetTheCooldown(2);
        if (isMarked) {
            isMarked = false;
            spellQ = new Description(0, (int) (abilityPower * 3), 0, 0, 0, 0, false);
        } else {
            spellQ = new Description(0, (int) (abilityPower * 1.5), 0, 0, 0, 0, false);
        }
        return new Spell(spellQ, 2);
    }

    @Override
    public Spell provideW(Enemy enemy) {
        int random = MathHelper.randomInt(1, 6);
        if (random == 1) {
            abilityPower = abilityPower + 5;
            //soundHandler.playSound(RyzeSounds.W1);
            System.out.println("Ryze gained 5 AP");
        } else if (random == 2) {
            resetTheCooldown(0);
            //soundHandler.playSound(RyzeSounds.W2);
            System.out.println("Ryze: Q COOLDOWN HAS BEEN RESET!");
        } else if (random == 3) {
            resetTheCooldown(1);
            //soundHandler.playSound(RyzeSounds.W3);
            System.out.println("Ryze: W COOLDOWN HAS BEEN RESET!");
        } else if (random == 4) {
            resetTheCooldown(2);
            //soundHandler.playSound(RyzeSounds.W4);
            currentActionPoints++;
            System.out.println("Ryze: E COOLDOWN HAS BEEN RESET! Gained 1 action point");
        } else if (random == 5) {
            currentActionPoints++;
            System.out.println("Ryze: Gained 1 action points");
        } else if (random == 6) {
            System.out.println("The scroll has burned out. Nothing happens.");
        }
        return new Spell(new Description(),1);
    }

    @Override
    public Spell provideE(Enemy enemy) {
        isMarked = true;
        resetTheCooldown(0);
         Description spellE = new Description(0,0, (int) (abilityPower*0.6),0,0,0,false);
         return new Spell(spellE,1);
    }

    @Override
    public Spell provideR(Enemy enemy) {
        return null;
    }
}

/*
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
            //soundHandler.playSound(RyzeSounds.W1);
            System.out.println("Ryze gained 5 AP");
        } else if (random == 2) {
            // resets Q cooldown
            //soundHandler.playSound(RyzeSounds.W2);
            System.out.println("Ryze: Q COOLDOWN HAS BEEN RESET!");
        } else if (random == 3) {
           // resets W cooldown
            //soundHandler.playSound(RyzeSounds.W3);
            System.out.println("Ryze: W COOLDOWN HAS BEEN RESET!");
        } else if (random == 4) {
            // resets E cooldown
            //soundHandler.playSound(RyzeSounds.W4);
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
/*
    @Override
    public Description useE(Enemy enemy) {
        isMarked = true;
        //todo resets Q cooldown
        return new Description(0,0, (int) (abilityPower*0.6),0,0,0,false);
    }
/*
    @Override
    public Description useR(Enemy enemy) {
        //todo gains 5 ActionPoints or come up with new idea
        return null;
    }

    @Override
    public Spell provideQ(Enemy enemy) {
        return null;
    }

    @Override
    public Spell provideW(Enemy enemy) {
        return null;
    }

    @Override
    public Spell provideE(Enemy enemy) {
        return null;
    }

    @Override
    public Spell provideR(Enemy enemy) {
        return null;
    }
}
*/