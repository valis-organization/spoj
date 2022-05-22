package oop.LeagueOfBattle.champions.base.spell;

public class Spell {
    public Description description;
    public int actionPointsCost;
    public boolean isSpellOnCooldown;
    private SpellListener spellListener;

    public Spell(Description description, int actionPointsCost, SpellListener spellListener ) {
        this.description = description;
        this.actionPointsCost = actionPointsCost;
        isSpellOnCooldown = false;
        this.spellListener = spellListener;
    }

    public void use(){
        spellListener.onSpellUsed();
    }

}

