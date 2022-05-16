package oop.LeagueOfBattle.champions.base.spell;

import oop.LeagueOfBattle.champions.base.Enemy;

public interface SpellProvider {
    Spell provideAA(Enemy enemy);

    Spell provideQ(Enemy enemy);

    Spell provideW(Enemy enemy);

    Spell provideE(Enemy enemy);

    Spell provideR(Enemy enemy);

    Spell providePassive(Enemy enemy);
}
