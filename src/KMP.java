import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * https://pl.spoj.com/problems/KMP/
 */
public class KMP {

    public static List<Integer> matchingPositions(String pattern, String stringToCheck, int patternLength) {
        char[] patternInChar = pattern.toCharArray();
        char[] stringToCheckInChar = stringToCheck.toCharArray();
        boolean doesPatternMatch = false;
        List<Integer> positions=new ArrayList<Integer>();
        if (pattern.length() > stringToCheck.length()) {
            return positions;
        } else {
            for (int i = 0; i < stringToCheck.length(); i++) {
                if (stringToCheck.length() - i>=patternLength-1) {
                    if (doesPatternMatch)
                        positions.add(i - 1);
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
        } return positions;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount,patternLength;
        testCount = scan.nextInt();

        String pattern, stringToCheck;
        for (int i = 0; i < testCount; i++) {
            patternLength = scan.nextInt();
            pattern = scan.next();
            stringToCheck = scan.next();
            int sizeOfList = matchingPositions(pattern,stringToCheck,patternLength).size();
            for(int j = 0; j<sizeOfList;j++)
           System.out.println(matchingPositions(pattern, stringToCheck, patternLength).get(j));

        }
    }
}
