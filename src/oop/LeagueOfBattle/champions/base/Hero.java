package oop.LeagueOfBattle.champions.base;

public abstract class Hero {
    public float hp;
    public float armor;
    public float magicResist;
    public float abilityPower;
    public float attackDimig;
    public int actionPoints;
    public int startingActionPoints;

    public abstract void getDemage(float attackDimig);

    public abstract void basicAttack(Hero hero);

    public abstract void spellQ(Hero hero);

    public abstract void spellW();

    public abstract void spellE();

    public abstract void ultimateSpell();

    public abstract void passiveSpell();
}
