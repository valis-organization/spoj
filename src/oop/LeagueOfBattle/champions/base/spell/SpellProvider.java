package oop.LeagueOfBattle.champions.base.spell;

public interface SpellProvider {
    Spell provideAA();

    Spell provideQ();

    Spell provideW();

    Spell provideE();

    Spell provideR();

    Spell providePassive();
}
