import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://www.spoj.com/problems/PALIN/
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount, asd;
        testCount = scan.nextInt();

        for (int i = 0; i < testCount; i++) {
            asd = scan.nextInt();
            System.out.println("Jednosci: " + asd % 10);
            System.out.println("Dziesiatki: " + ((asd % 100) - (asd % 10)) / 10);


        }

    }
}
