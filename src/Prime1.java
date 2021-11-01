import java.util.Scanner;

import static java.lang.Math.*;

/***
 * https://www.spoj.com/problems/PRIME1/
 */
public class Prime1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t;
        boolean p[];
        t = scan.nextInt();
        if (t <= 10) {
            for (int i = 0; i < t; i++) {
                int m = scan.nextInt();
                int n = scan.nextInt();
                p = new boolean[n];
                if (1 <= m && m <= n && n - m <= 1000000 && n <= 1000000000) {
                    for (int a = m; a < n; a++) {
                        if (a != 1)
                            p[a - 1] = true;
                    }

                    for (int j = 2; j <= n; j++) {
                        if (p[j - 1])
                            System.out.println(j);
                        for (int d = 2 * j; d <= n; d = d + j)
                            p[d - 1] = false;
                    }
                }

            }
        }
    }
}



