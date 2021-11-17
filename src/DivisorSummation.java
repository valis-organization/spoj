import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://www.spoj.com/problems/DIVSUM/
 */

public class DivisorSummation {

    public static void main(String[] args) {
        int testCount, baseNumber, summation = 0;
        Scanner scan = new Scanner(System.in);
        testCount = scan.nextInt();
        for (int i = 0; i < testCount; i++) {
            baseNumber = scan.nextInt();
            for (int j = 1; j < baseNumber; j++) {
                if (baseNumber % j == 0) {
                    summation += j;

                }
            }
            System.out.println(summation);
            summation = 0;
        }
    }
}
// git reset --hard HEAD
