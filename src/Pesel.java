import java.util.Scanner;
//RAFALCHAMPIK

/***
 * https://pl.spoj.com/problems/JPESEL/
 */

public class Pesel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount;
        String peselNumbers;
        testCount = scan.nextInt();

        for (int i = 0; i <= testCount; i++) {
            peselNumbers = scan.nextLine();
            char[] convert = peselNumbers.toCharArray();
        //    for(int j= 0; j< convert.length;j++){
          //      System.out.println(convert);
            //}
            int suma = convert[0] + (convert[1] * 3) + convert[2] * 7 + convert[3] * 9 + convert[4] + convert[5] * 3 + convert[6] * 7 + convert[7] * 9 + convert[8] + convert[9] * 3 + convert[10];
            System.out.println(suma);
        }
    }

}


