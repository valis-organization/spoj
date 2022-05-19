package oop.LeagueOfBattle.champions.base.spell;

public class Description {
    public int removedActionPoints;
    public int adDmg;
    public int apDmg;
    public boolean trueDmg;
    public float armorPen;
    public float magicPen;
    public boolean damageByMissingHp;

    public Description(int removedActionPoints, int addDmg, int apDmg, boolean trueDmg, float armorPen, float magicPen, boolean damageByMissingHp) {
        this.removedActionPoints = removedActionPoints;

        this.adDmg = addDmg;
        this.apDmg = apDmg;
        this.trueDmg = trueDmg;
        this.armorPen = armorPen;
        this.magicPen = magicPen;
    }

    public Description() {
        this.removedActionPoints = 0;
        this.adDmg = 0;
        this.apDmg = 0;
        this.trueDmg = false;
        this.armorPen = 0;
        this.magicPen = 0;
        this.damageByMissingHp = false;
    }

}
