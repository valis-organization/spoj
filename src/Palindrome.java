import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://www.spoj.com/problems/PALIN/
 */
public class Palindrome {
    static char[] longToCharArray(long number) {
        String strnumber = String.valueOf(number); // konwertowanie longa do stringa
        char[] palinCharArray = strnumber.toCharArray(); // konwertowanie stringa do chara
        return palinCharArray;
    }

    static boolean isNumberPalindrome(long palindrome) {
        char[] palinCharArray = longToCharArray(palindrome);
        boolean numberIsPalindrome = false;
        int palinArray[];
        palinArray = new int[palinCharArray.length];
        for (int j = 0; j < palinCharArray.length; j++) {
            int palin = Integer.parseInt(String.valueOf(palinCharArray[j])); //konwertowanie chara do inta
            palinArray[j] = palin; // wkladanie chara j do arraya;
        }

        for (int i = 1; i < palinArray.length; i++) {
            if (palinArray[i-1] == palinArray[palinArray.length - i])
                numberIsPalindrome = true;
            else{
                numberIsPalindrome = false;
                break;
            }

        }
        if(numberIsPalindrome == true)
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
                if (isNumberPalindrome(palindrome) == true) {
                    for (long j = 1; j < 1000000; j++) {
                        if (isNumberPalindrome(palindrome + j) == true) {
                            System.out.println(palindrome + j);
                            break;
                        }
                    }
                }
                else
                    System.out.println("Liczba nie jest palindromem");
            }

        }

    }
}
