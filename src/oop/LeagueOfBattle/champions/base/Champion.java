package oop.LeagueOfBattle.champions.base;

import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.voiceLines.SoundHandler;

import javax.swing.text.DefaultEditorKit;
import java.util.Collections;
import java.util.List;

public abstract class Champion {
    protected String name;
    //hp
    protected int maxHP;
    protected int hp;
    //defense
    protected int armor;
    protected int magicResist;
    //damage
    protected int abilityPower;
    protected int attackDimig;
    protected float armorPenetration;
    protected float magicPenetration;

    protected int actionPoints;
    protected int currentActionPoints; //TODO why public

    protected String soundPath;//todo interface? Sound provider?
    protected boolean isAssasin;  //todo interface?
    protected SoundHandler soundHandler = new SoundHandler(); //todo pass as argument / necessary?

    protected List<Spell> spells = Collections.emptyList();

    public final void receiveSpell(Description description) {

        int relativeArmor = (int) ((armor * (1 - armorPenetration)) / 2);
        int relativeMR = (int) ((magicResist * (1 - magicPenetration)) / 2);
        relativeArmor = relativeArmor == 0 ? 1 : relativeArmor;
        relativeMR = relativeMR == 0 ? 1 : relativeMR;

        this.hp = hp - description.addDmg / relativeArmor;
        this.hp = hp - description.apDmg / relativeMR;
        this.hp = hp - description.trueDmg;
        this.currentActionPoints = currentActionPoints - description.removedActionPoints;

    }
    public Description useAA(){
        return new Description(0,attackDimig,0,0,0,0);
    }
    abstract public Description useQ();
    abstract public Description useW();
    abstract public Description useE();
    abstract public Description useR();

    public List<Spell> usableSpells() {
        List<Spell> spellsWithoutCooldown = spells;
        for (Spell spell : spells) {
            if (!spell.isOnCooldown) {
                spellsWithoutCooldown.remove(spell);
            }
        }
        return spellsWithoutCooldown;
    }

    //reset
    public final void resetCurrentActionPoints() { //
        currentActionPoints = actionPoints;
    }

    public final void resetCooldowns() {
        for (Spell spell : spells) {
            spell.isOnCooldown = false;
        }
    }

    //getters, setters
    public final String getName() {
        return name;
    }

    public final String getSound() {
        return soundPath;
    }

    public final float getHp() {
        return hp;
    }

    public final float getArmor() {
        return armor;
    }

    public final int getCurrentActionPoints() {
        return currentActionPoints;
    }

    public final boolean isAssasin() {
        return isAssasin;
    }

    @Override
    public String toString() {
        return name;
    }

}
