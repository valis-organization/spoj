package oop.LeagueOfBattle.champions.base.spell;

public class Description {
    public int removedActionPoints;

    public int addDmg = 0;
    public int apDmg = 0;
    public int trueDmg = 0;
    public float armorPen = 0;
    public float magicPen = 0;
    public int missingHp = 0;

    public Description(int removedActionPoints, int addDmg, int apDmg, int trueDmg, float armorPen, float magicPen) {
        this.removedActionPoints = removedActionPoints;

        this.addDmg = addDmg;
        this.apDmg = apDmg;
        this.trueDmg = trueDmg;
        this.armorPen = armorPen;
        this.magicPen = magicPen;
    }

    public Description() {
        this.removedActionPoints = 0;
        this.addDmg = 0;
        this.apDmg = 0;
        this.trueDmg = 0;
        this.armorPen = 0;
        this.magicPen = 0;
    }

}
