import java.util.Scanner;

/**
 * handles game and user input
 */
public class Main {
    public static void main(String[] args) {
        //sets win condition, turn, scanner and boar
        int win = 1;
        String turn  = "w";
        Scanner inp = new Scanner(System.in);
        Board board = new Board();
        board.draw();
        Men check = new S(0,"w");
        //checks for win
        while(check.getCaptures() < win) {
            //checks whether we want to move or capture
            System.out.println("Move or Capture?");
            String choice = inp.nextLine();
            // for each option, gets user input and repeatedly asks until input is valid, then carries out task.
            if (choice.equals("Move")) {
                System.out.println("Input Row");
                int row = inp.nextInt();
                System.out.println("Input Column");
                int column = inp.nextInt();
                while (!(row >= 0 && row < 16 && column >= 0 && column < 8 && board.getBoard()[row][column].getColor().equals(turn))) {
                    System.out.println("Invalid start location");
                    System.out.println("Input Row");
                    row = inp.nextInt();
                    System.out.println("Input Column");
                    column = inp.nextInt();
                }
                board.move(row, column);
            }
            if (choice.equals("Siege")) {
                System.out.println("Input Row");
                int row = inp.nextInt();
                System.out.println("Input Column");
                int column = inp.nextInt();
                while (!(row >= 0 && row < 16 && column >= 0 && column < 8 && board.getBoard()[row][column].getColor().equals(board.opposite(turn)))) {
                    System.out.println("Invalid location");
                    System.out.println("Input Row");
                    row = inp.nextInt();
                    System.out.println("Input Column");
                    column = inp.nextInt();
                }
                board.siege(row, column);
            }
            if (choice.equals("Deceit")) {
                System.out.println("Input Row");
                int row = inp.nextInt();
                System.out.println("Input Column");
                int column = inp.nextInt();
                while (!(row >= 0 && row < 16 && column >= 0 && column < 8 && board.getBoard()[row][column].getColor().equals(board.opposite(turn)))) {
                    System.out.println("Invalid location");
                    System.out.println("Input Row");
                    row = inp.nextInt();
                    System.out.println("Input Column");
                    column = inp.nextInt();
                }
                board.deceit(row, column);
            }
            if (choice.equals("Assault")) {
                System.out.println("Input Row");
                int row = inp.nextInt();
                System.out.println("Input Column");
                int column = inp.nextInt();
                System.out.println("Input Target Row");
                int targetRow = inp.nextInt();
                System.out.println("Input Target Column");
                int targetColumn = inp.nextInt();
                while (!(row >= 0 && row < 16 && column >= 0 && column < 8 && targetRow >= 0 && targetRow < 16 && targetColumn >= 0 && targetColumn < 8 && board.getBoard()[row][column].getColor().equals(turn) && board.getBoard()[targetRow][targetColumn].getColor().equals(board.opposite(turn)))) {
                    System.out.println("One location invalid");
                    System.out.println("Input Row");
                    row = inp.nextInt();
                    System.out.println("Input Column");
                    column = inp.nextInt();
                    System.out.println("Input Target Row");
                    targetRow = inp.nextInt();
                    System.out.println("Input Target Column");
                    targetColumn = inp.nextInt();
                }
                board.assault(row, column, targetRow, targetColumn);
            }
            // updates turn and board
            turn = board.opposite(turn);
            board.draw();
        }
        //prints winner.
        System.out.println("Player "+board.opposite(turn)+" wins!");
    }
}
