package oop.LeagueOfBattle.helpers;

public class MathHelper {
    public static int randomInt(int min, int max) {
        return (int) ((Math.random() * max) + min);
    }

    public static boolean randomBoolean() {
        return randomInt(1, 2) == 1;
    }
}
