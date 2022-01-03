import java.util.Scanner;

/***
 * https://pl.spoj.com/problems/PP0504B/
 */

public class StringMerge {


    static char[] firstStringToCharArray(String firstRow) {
        char[] convertedFirst = firstRow.toCharArray(); // konwertowanie pierwszego ciagu do chara
        return convertedFirst;
    }

    static char[] secondStringToCharArray(String secondRow) {
        char[] convertedSecond = secondRow.toCharArray(); // konwertowanie drugiego ciagu do chara
        return convertedSecond;
    }

    static boolean isFirstRowLongerThanSecond(String firstRow, String secondRow) {
        int secondLength = secondRow.length();
        int firstLength = firstRow.length();
        if (firstLength > secondLength)
            return true;
        else
            return false;
    }

    static String string_merge(String firstRow, String secondRow) {
        char[] convertedFirst = firstStringToCharArray(firstRow);
        char[] convertedSecond = secondStringToCharArray(secondRow);
       // char[] finalStringInChar;

        if (isFirstRowLongerThanSecond(firstRow, secondRow)) {
            char[] finalStringInChar = new char[secondRow.length()*2];
            for (int i = 0; i < secondRow.length(); i++) {
                finalStringInChar[i] = convertedFirst[i];
                finalStringInChar[i+1] = convertedSecond[i];
            }
            String finalString = String.valueOf(finalStringInChar);
            return finalString;
        } else {
            char[] finalStringInChar = new char[firstRow.length()*2];
            for (int i = 0; i < firstRow.length(); i++) {
                finalStringInChar[i] = convertedFirst[i];
                finalStringInChar[i+1] = convertedSecond[i];
            }
            String finalString = String.valueOf(finalStringInChar);
            return finalString;
        }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount;
        String firstRow, secondRow;
        testCount = scan.nextInt();
        for (int i = 0; i < testCount; i++) {
            firstRow = scan.next();
            secondRow = scan.next();
            System.out.println(string_merge(firstRow,secondRow));
        }
    }


}
