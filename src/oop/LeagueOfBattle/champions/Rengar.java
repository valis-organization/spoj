package oop.LeagueOfBattle.champions;

import oop.LeagueOfBattle.champions.base.Champion;
import oop.LeagueOfBattle.champions.base.Enemy;
import oop.LeagueOfBattle.champions.base.spell.Description;
import oop.LeagueOfBattle.champions.base.spell.Spell;
import oop.LeagueOfBattle.helpers.MathHelper;
import oop.LeagueOfBattle.menagers.ChampionVoiceLineHandler;
import oop.LeagueOfBattle.menagers.SubtitlesPrinter;

public class Rengar extends Champion {
    private final String NAME = "Rengar";

    public Rengar(ChampionVoiceLineHandler rengarVoiceHandler, SubtitlesPrinter subtitlesPrinter) {
        super(rengarVoiceHandler, subtitlesPrinter);
        name = NAME;
        maxHP = 200;
        currentHp = 200;
        armor = 20;
        magicResist = 10;
        abilityPower = 0;
        attackDimig = 50;
        actionPoints = 4;
        armorPenetration = 20;
        currentActionPoints = actionPoints;
        costQ = 2;
        costW = 1;
        costE = 2;
        costR = actionPoints;
        isAssassin = true;
    }

    @Override
    public Spell provideAA(Enemy enemy) {
        Description AA = new Description(0, attackDimig, 0, 0, 0, 0, false);
        return new Spell(AA, 1);
    }

    @Override
    public Spell provideQ(Enemy enemy) {
        Description spellQ = new Description(0, attackDimig * 3, 0, 0, armorPenetration, 0, false);
        return new Spell(spellQ, costQ);
    }

    @Override
    public Spell provideW(Enemy enemy) {
        int healedHp = MathHelper.randomInt(0, 21);

        if ((MathHelper.randomInt(1, 2) == 1)) {
            currentHp = currentHp + healedHp;
            subtitlesPrinter.rengarSuccessfulHeal(healedHp, currentHp);
        } else {
            subtitlesPrinter.rengarUnSuccessfulHeal();
        }
        Description spellW = new Description();
        return new Spell(spellW, costW);
    }

    @Override
    public Spell provideE(Enemy enemy) {
        Description spellE = new Description(1, (int) (attackDimig * 0.9), 0, 0, 0, 0, false);
        return new Spell(spellE, costE);
    }

    @Override
    public Spell provideR(Enemy enemy) {
        attackDimig = attackDimig + 20;
        useQ(enemy);
        provideE(enemy);
        provideW(enemy);
        provideE(enemy);
        attackDimig = attackDimig - 20;
        return new Spell(new Description(), costR);
    }

    @Override
    public Spell providePassive(Enemy enemy) {
        attackDimig = attackDimig + 5;
        subtitlesPrinter.rengarPrintPassive();
        return new Spell(new Description(), 0);
    }
    /*

    @Override
    public void ultimateSpell(Champion champion) {
        //rengar unleash his power
        if (currentActionPoints >= 3) {
            if (!isUltimateOnCooldown) {
                currentActionPoints = 10;
                attackDimig = attackDimig + 20;
                spellQ(champion);
                spellW();
                spellE(champion);
                currentActionPoints = 0;
                attackDimig = attackDimig - 20;
                isUltimateOnCooldown = true;
            } else {
            }
                System.out.println("Your spell is on cooldown!");
        } else {
            System.out.println("You dont have enough Action Points! Your current Action Points: " + currentActionPoints);
        }
    }

    @Override
    public void passiveSpell() {
        //Bonetooth necklace: Rengar collets Thropies for his victims (every round +5 AD)
        attackDimig = attackDimig + 5;
        System.out.println("Bonetooth necklace: Rengar got +5 AD");
    }
*/
}
