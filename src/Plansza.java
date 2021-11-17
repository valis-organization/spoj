import java.util.Scanner;

public class Plansza {

    static int board_Y = 10;
    static int board_X = 5;

    public static void main(String[] args) {
        char key;
   /*     Thread thread = new Thread(() -> {

        });
        thread.start();
     */   Scanner scan = new Scanner(System.in);


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
            board[playerPosX][playerPosY] = "O"; //Pozycja poczatkowa

            for (int i = 0; i < board_X; i++) {
                System.out.println("");
                for (int j = 0; j < board_Y; j++) {
                    if (board[playerPosX][playerPosY] == board[i][j]) { // Rysuje plansze
                        board[i][j] = "O";
                        System.out.print(board[i][j]);
                    } else {
                        board[i][j] = "X";
                        System.out.print(board[i][j]);
                    }

                }
            }
            key = scan.next().charAt(0);
            board[previousPosX][previousPosY] = "X"; // Pozycja poprzednia
            if (key == 'A' || key == 'a') {   // Chodzenie (poki co 4 = Gora, 3 = Dol, 2 = Prawo, 1 = Lewo
                playerPosY --;
            }
            if (key == 'D' || key =='d') {
                playerPosY++;
            }
            if(key == 'S' || key == 's'){
                playerPosX++;
            }
            if(key=='W' || key == 'w'){
                playerPosX--;
            }


            if(playerPosX>=board_X) //Nie wychodzi poza granice planszy
                playerPosX--;
            if(playerPosY>=board_Y)
                playerPosY--;
            if(playerPosX<0)
                playerPosX++;
            if(playerPosY<0)
                playerPosY++;

        }while (true) ;



    }
}
