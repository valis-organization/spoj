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
                if (1 <= m && m <= n && n - m <= 1000000 && n <= 1000000000) {
                    for (int p = m; p <= n; p++) {
                        if (p != 1) {
                            if (p % 2 != 0 || p == 2) {
                                if (p % 3 != 0 || p == 3) {
                                    if (p % 5 != 0 || p == 5) {
                                        if (p % 7 != 0 || p == 7) {
                                            System.out.println(p);
                                        }

                                    }

                                }

                            }
                        }
                    }
                }


            }

        }
    }
}