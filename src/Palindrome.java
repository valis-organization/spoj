import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://www.spoj.com/problems/PALIN/
 */
public class Palindrome {
    static char[] longToCharArray(long number) {
        String strnumber = String.valueOf(number); // konwertowanie longa do stringa
        char[] convert = strnumber.toCharArray(); // konwertowanie stringa do chara
        return convert;
    }

    static boolean isNumberPalindrome(long palindrome) {
        char[] convert = longToCharArray(palindrome);
        boolean ok;
        for (int i = 0; i < convert.length; i++) {
            if (convert[i] == convert[convert.length - i])
                ok = true;
            else
                ok = false;
        }
        if(ok = true)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount;
        long palindrome;
        testCount = scan.nextInt();

        for (int i = 0; i < testCount; i++) {
            palindrome = scan.nextLong();
            if (palindrome <= 1000000) {
                if (isNumberPalindrome(palindrome) == true)
                    System.out.println("Seima");
                else
                    System.out.println("nie siema");
            }

        }

    }
}
