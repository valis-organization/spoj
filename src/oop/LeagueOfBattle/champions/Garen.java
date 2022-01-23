package oop.LeagueOfBattle.champions;


import oop.LeagueOfBattle.champions.base.Hero;

public class Garen extends Hero {

    public Garen() {
        name = "Garen";
        hp = 100;
        armor = 20;
        magicResist = 20;
        abilityPower = 0;
        attackDimig = 20;
        actionPoints = 3;
        currentActionPoints = actionPoints;
        isSpellOnCooldown = new boolean[3];
    }

    @Override
    public void getDemage(float attackDimig) {
        hp = hp - (attackDimig / (armor / 2));
        System.out.println(this.getClass().getSimpleName() + " had suffered " + attackDimig / (armor / 2) + " demage.");
    }

    @Override
    public void basicAttack(Hero hero) {
        hero.getDemage(attackDimig);
        currentActionPoints--;
    }

    @Override
    public void spellQ(Hero hero) {
        //Garen deals damage (3x his base ad)
        if (!isSpellOnCooldown[0]) {
            if (currentActionPoints >= 2) {
                System.out.println("DEMACIA!!!!");
                hero.getDemage(attackDimig * 3);
                currentActionPoints = currentActionPoints - 2;
                isSpellOnCooldown[0] = true;
            } else {
                System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
            }
        } else {
            System.out.println("Your spell is on cooldown!");
        }
    }

    @Override
    public void spellW() {
        //Adding amount of armor and magic resist per use - 1 Action Point
        armor = (float) (armor + 1.5);
        magicResist = (float) (magicResist + 1.5);
        System.out.println("Increased your armor and MR! Now A: " + armor + " MR: " + magicResist);
        currentActionPoints--;
    }

    @Override
    public void spellE(Hero hero) {

    }

    @Override
    public void ultimateSpell() {

    }

    @Override
    public void passiveSpell() {

    }

}
