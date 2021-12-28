import java.util.Scanner;

/***
 * https://pl.spoj.com/problems/KMP/
 */
public class KMP {

    public static void matchingPositions(String pattern, String stringToCheck, int patternLength) {
        char[] patternInChar = pattern.toCharArray();
        char[] stringToCheckInChar = stringToCheck.toCharArray();
        boolean doesPatternMatch = false;
        if (pattern.length() > stringToCheck.length()) {
            System.out.print("");
        } else {
            for (int i = 0; i < stringToCheck.length(); i++) {
                if (stringToCheck.length() - i>=patternLength-1) {
                    if (doesPatternMatch)
                        System.out.println(i - 1);
                    doesPatternMatch = false;
                    for (int j = 1; j < patternLength; j++) {
                        if (patternInChar[0] == stringToCheckInChar[i]) {
                            if (patternInChar[j] == stringToCheckInChar[i + j]) {
                                doesPatternMatch = true;
                            } else
                                doesPatternMatch = false;
                        }

                    }
                }else
                    break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount;
        testCount = scan.nextInt();
        int patternLength;
        String pattern, stringToCheck;
        for (int i = 0; i < testCount; i++) {
            patternLength = scan.nextInt();
            pattern = scan.next();
            stringToCheck = scan.next();
            matchingPositions(pattern, stringToCheck, patternLength);
        }
    }
}
