package oop.LeagueOfBattle.champions.base;

import java.util.Arrays;

public abstract class Hero {
    protected String name;
    protected float hp;
    protected float armor;
    protected float magicResist;
    protected float abilityPower;
    protected float attackDimig;
    protected float armorPenetration;
    protected int actionPoints;
    public int currentActionPoints; //protected ma byc, ale inne klasy nie moga zmienic tej zmiennej - zapytac przemka xd
    protected boolean[] isSpellOnCooldown;

    public abstract void getDemage(float attackDimig);

    public final float getHp() {
        return hp;
    }

    public final float getArmorPenetration() {
        return armorPenetration;
    }

    public final int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public final void resetCurrentActionPoints() {
        currentActionPoints = actionPoints;
    }

    public final void resetCooldowns() {
        Arrays.fill(isSpellOnCooldown, false);
    }

    public abstract void basicAttack(Hero hero);


    public abstract void spellQ(Hero hero);

    public abstract void spellW();

    public abstract void spellE(Hero hero);

    public abstract void ultimateSpell();

    public abstract void passiveSpell();
    @Override
    public String toString() {
        return name;
    }
}
