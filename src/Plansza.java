import java.util.Scanner;

public class Plansza {

    static int board_Y = 10;
    static int board_X = 5;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key;

        String board[][] = new String[board_X][board_Y];
        int playerPosX = board_X - 5;
        int playerPosY = board_Y - 1;
        board[playerPosX][playerPosY] = "O"; // Pozycja poczatkowa
       // do {
            for (int i = 0; i < board_X; i++) {
                System.out.println("");
                for (int j = 0; j < board_Y; j++) {
                    if(board[playerPosX][playerPosY] == board[i][j]){
                        board[i][j]= "O";
                    System.out.print(board[i][j]);}
                    else{
                        board[i][j] = "X";
                    System.out.print(board[i][j]);}

                }
            }
            key = scan.nextLine();
        //}while(key == "W" || key == "A" || key == "S" || key == "D");
          /*          String key = scan.nextLine();
            if (key == "W"){
                playerPosY++;
            }
            if(key== "S"){
                playerPosY--;
   */
    }

}
