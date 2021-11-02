import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://www.spoj.com/problems/DIVSUM/
 */

public class DivisorSummation {

    public static void main(String[] args) {
        int testy, liczba, suma = 0;
        Scanner scan = new Scanner(System.in);
        testy = scan.nextInt();
        for (int i = 0; i < testy; i++) {
            liczba = scan.nextInt();
            for (int j = 1; j < liczba; j++) {
                if (liczba % j == 0) {
                    suma += j;

                }
            }
            System.out.println(suma);
            suma = 0;
        }
    }
}

