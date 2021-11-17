import java.util.Scanner;

public class Plansza {

    static int board_Y = 10;
    static int board_X = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key;

        String board[][] = new String[board_X][board_Y];
        int playerPosX = (board_X - 5);
        int playerPosY = (board_Y - 1);
        int previousPosX, previousPosY;

        do {
            for (int m = 0; m < 5; m++) {
                System.out.println("\n");
            }
            previousPosX = playerPosX;
            previousPosY = playerPosY;
            board[playerPosX][playerPosY] = "O"; // Pozycja poczatkowa

            for (int i = 0; i < board_X; i++) {
                System.out.println("");
                for (int j = 0; j < board_Y; j++) {
                    if (board[playerPosX][playerPosY] == board[i][j]) {
                        board[i][j] = "O";
                        System.out.print(board[i][j]);
                    } else {
                        board[i][j] = "X";
                        System.out.print(board[i][j]);
                    }

                }
            }
            key = scan.nextInt();
            board[previousPosX][previousPosY] = "X"; // Pozycja poprzednia
            if (key == 1) {
                playerPosY --;
            }
            if (key == 2) {
                playerPosY++;
            }
            if(key == 3){
                playerPosX++;
            }
            if(key==4){
                playerPosX--;
            }

            if(playerPosX>=5)
                playerPosX--;
            if(playerPosY>=10)
                playerPosY--;
            if(playerPosX<0)
                playerPosX++;
            if(playerPosY<0)
                playerPosY++;

        }while (key == 1 || key == 2 || key == 3 || key == 4) ;



    }
}
