package oop.LeagueOfBattle.champions.base;

public class Spell {
    Type type;
    Details details;

    public class Details {
        public boolean isOnCooldown = false;
        public int actionPointsCost = 0;

        public int addDmg = 0;
        public int apDmg = 0;
        public int trueDmg = 0;
        public float armorPen = 0;
        public float magicPen = 0;
    }

    enum Type{
        Q,
        W,
        E,
        R,
        PASSIVE,
        AA
    }
}

