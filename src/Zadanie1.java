import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;

        while (true) {
            x = scan.nextInt();
            if (x == 42) break;
            System.out.println(x);

        }


    }
}