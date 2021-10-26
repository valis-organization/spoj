import java.util.Scanner;

public class Zadanie2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        if (t > 100) System.exit(0);
        if (t < 0) System.exit(0);
        for (int i = 0; i < t; i++) {
            System.out.println("Siema");
        }


    }
}
