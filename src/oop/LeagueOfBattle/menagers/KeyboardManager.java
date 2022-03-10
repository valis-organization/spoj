package oop.LeagueOfBattle.menagers;


import oop.LeagueOfBattle.champions.base.spell.KeyType;

import java.security.Key;
import java.util.Scanner;

public class KeyboardManager {

    public static KeyType getKey() {
        Scanner scan = new Scanner(System.in);
        String key = scan.next();
        switch (key) {
            case "AA": {
                return KeyType.AA;
            }
            case "Q": {
                return KeyType.Q;
            }
            case "W": {
                return KeyType.W;
            }
            case "E": {
                return KeyType.E;
            }
            case "R": {
                return KeyType.R;
            }
        }
        return KeyType.UNKNOWN;
    }
}
