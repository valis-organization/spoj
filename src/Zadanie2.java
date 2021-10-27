import java.util.Scanner;

/***
 * https://www.spoj.com/problems/SMPDIV/
 */
public class Zadanie2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        if (t > 100) System.exit(0);
        if (t < 0) System.exit(0);
        for (int i = 0; i < t; i++) {
            int n, x, y, ai;
            n = scan.nextInt();
            x = scan.nextInt();
            y = scan.nextInt();
            if (x < n && x % n != 0) {
                for (ai = 0; ai < n; ai++) {
                    if (ai % x == 0 && ai % y != 0)
                        System.out.println(ai);
                }
            } else
                System.out.println("ERROR");
        }


    }
}
