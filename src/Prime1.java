import java.util.Scanner;

/***
 * https://www.spoj.com/problems/PRIME1/
 */
public class Prime1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        if (t <= 10) {
            for (int i = 0; i < t; i++) {
                int m = scan.nextInt();
                int n = scan.nextInt();
                System.out.println(m + " " + n);
            }
        }


    }
}
