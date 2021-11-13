import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://pl.spoj.com/problems/JPESEL/
 */


public class Pesel {
    static char[] longToCharArray ( long number){
        String strpesel = String.valueOf(number); // konwertowanie longa do stringa
        char[] convert = strpesel.toCharArray(); // konwertowanie stringa do chara
        return convert;
    }

    static boolean isPeselValid(long pesel){
        char[] convert = longToCharArray(pesel);
        int numberOfPesel; // zmienna koncowa (przekonwertowany long do stringa, string do chara, char do inta)
        int suma = 0;

        for (int j = 0; j < convert.length; j++) {

            numberOfPesel = Integer.parseInt(String.valueOf(convert[j])); //konwertowanie chara do inta
            if (j == 0 || j == 4 || j == 8 || j == 10)
                suma += numberOfPesel;
            if (j == 1 || j == 5 || j == 9)
                suma += numberOfPesel * 3;
            if (j == 2 || j == 6)
                suma += numberOfPesel * 7;
            if (j == 3 || j == 7)
                suma += numberOfPesel * 9;
        }
        if (suma % 10 == 0)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {

        long peselNumbers;
        Scanner scan = new Scanner(System.in);
        int testCount;
        testCount = scan.nextInt();
        if (testCount <= 100) {
            for (int i = 0; i < testCount; i++) {

                peselNumbers = scan.nextLong();
                isPeselValid(peselNumbers);
                if(isPeselValid(peselNumbers) == true)
                    System.out.println("D");
                else
                    System.out.println("N");
            }

        }
    }
}



