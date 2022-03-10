package oop.LeagueOfBattle.champions.base.spell;

public class Spell {
    public Description description;
    public int actionPointsCost;

    public Spell(Description description, int actionPointsCost) {
        this.description = description;
        this.actionPointsCost = actionPointsCost;
    }
}

