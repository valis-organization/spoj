package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Hero;

public class Rengar extends Hero {

    public Rengar(){
        hp = 50;
        armor = 10;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 80;
        actionPoints = 2;
        startingActionPoints = 2;
    }

    @Override
    public void getDemage(float attackDimig) {
        hp = hp - (attackDimig/(armor/2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig/(armor/2) + " demage." );
    }

    @Override
    public void basicAttack(Hero hero) {
        hero.getDemage(attackDimig);
        actionPoints--;
    }

    @Override
    public void spellQ(Hero hero) {
        //Basic attack with tripled damage
        hero.getDemage(attackDimig*3);
        actionPoints = actionPoints - 2;
    }

    @Override
    public void spellW() {

    }

    @Override
    public void spellE() {

    }

    @Override
    public void ultimateSpell() {

    }

    @Override
    public void passiveSpell() {

    }
    public void resetActionPoints(){
        this.actionPoints = 2;
    }
}
