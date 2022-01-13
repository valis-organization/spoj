package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Hero;

public class Garen extends Hero {

    public Garen() {
        hp = 100;
        armor = 20;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 20;
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
    public void resetActionPoitns(){
        this.actionPoints = 2;
    }
}
