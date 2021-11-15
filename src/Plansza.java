public class Plansza {

    static int board_Y = 10;
    static int board_X = 5;

    public static void main(String[] args) {

        String board[][] = new String[board_X][board_Y];
        for (int i = 0; i < board_X; i++) {
            System.out.println("");
            for (int j = 0; j < board_Y; j++) {
                board[i][j] = "X";
                System.out.print(board[i][j]);

            }
        }
    }

}
