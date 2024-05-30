import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  Board class which creates the board which creates the board and handles drawing the board as well as captures and moves
 *
 */
public class Board {

        Men[] whiteP1 = {new S(36,"w"),new S(25,"w"),new T(16,"w"), new T(9,"w"),new C(4,"w"), new C(1,"w")};
        Men[] blackP1 = {new S(64,"b"),new S(49,"b"),new T(36,"b"), new T(25,"b"),new C(16,"b")};
        P whiteP = new P( new ArrayList<Men>(Arrays.asList(whiteP1)),"w");
        P blackP = new P( new ArrayList<Men>(Arrays.asList(blackP1)),"b");
        private Men[][] board = {
                {new S(49,"b"),new S(121,"b"),null,null,null,null,new S(225,"b"), new S(361,"b")},
                {new S(28,"b"),new S(66,"b"),new T(36,"b"),new T(30,"b"),new T(56,"b"),new T(64,"b"),new S(120,"b"), blackP},
                {new T(16,"b"),new T(12,"b"),new C(9,"b"),new C(25,"b"),new C(49,"b"),new C(81,"b"),new T(90,"b"), new T(100,"b")},
                {null,null,new C(3,"b"),new C(5,"b"),new C(7,"b"),new C(9,"b"),null, null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new S(0,"w"),null,null,null,null,null,null,null},
                {new S(0,"b"),new S(0,"w"),new S(0,"b"),new S(0,"w"),null,null,null,null},
                {new S(0,"w"),null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,new S(8,"b"),null,null,null,null,null},
                {null,null,new C(8,"w"),new C(6,"w"),new C(4,"w"),new C(2,"w"),null, null},
                {new T(81,"w"),new T(72,"w"),new C(64,"w"),new C(36,"w"),new C(16,"w"),new C(4,"w"),new T(6,"w"), new T(9,"w")},
                {new S(153,"w"),whiteP,new T(49,"w"),new T(42,"w"),new T(20,"w"),new T(25,"w"),new S(45,"w"), new S(15,"w")},
                {new S(289,"w"),new S(169,"w"),null,null,null,null,new S(81,"w"), new S(25,"w")}
        };

        /**
         * retursn the board
         * @return the board
         */
        public Men[][] getBoard() {
                return board;
        }

        /**
         *
         * draws the board
         */
        public void draw() {
                System.out.println("____________________________________________________"); //top row
                int count = 0;
                for(Men[] i: board) {
                        //keeps count of row
                        if(count < 10) {
                                System.out.print(""+count+"  |");
                        }
                        else {
                                System.out.print(""+count+" |");
                        }
                        for(Men j: i) {
                                // writes out each piece
                                if(j == null) {
                                        System.out.print("     ");
                                }
                                else if(j.getVal() < 10) {
                                        System.out.print(""+j.getVal()+j.getSymbol()+j.getColor()+"  ");
                                }
                                else if(j.getVal() < 100) {
                                        System.out.print(""+j.getVal()+j.getSymbol()+j.getColor()+" ");
                                }
                                else{
                                        System.out.print(""+j.getVal()+j.getSymbol()+j.getColor());
                                }
                                System.out.print("|");
                        }
                        System.out.println("");
                        System.out.println("____________________________________________________");
                        count++;
                }
                System.out.println();
                //writes out pieces currently in white prymaid
                System.out.print("White pyramid: |");
                for(Men i: whiteP.getPieces()) {
                        if(i.getVal() < 10) {
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor()+"  ");
                        }
                        else if(i.getVal() < 100) {
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor()+" ");
                        }
                        else{
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor());
                        }
                        System.out.print("|");
                }
                //writes out pieces in black pyramid
                System.out.println();
                System.out.print("Black pyramid: |");
                for(Men i: blackP.getPieces()) {
                        if(i.getVal() < 10) {
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor()+"  ");
                        }
                        else if(i.getVal() < 100) {
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor()+" ");
                        }
                        else{
                                System.out.print(""+i.getVal()+i.getSymbol()+i.getColor());
                        }
                        System.out.print("|");
                }
                System.out.println();
        }

        /**
         * moves a piece from one place on the board to another
         * @param x row of piece that will be moved
         * @param y column of piece that will be moved
         */
        public void move(int x, int y) {
                ArrayList<int[]> output = board[x][y].moves(x,y); // gets possible moves and weeds out moves if they land on an occupied tile
                for(int i = 0; i < output.size();i++) {
                        if(board[output.get(i)[0]][output.get(i)[1]] != null) {
                                output.remove(i);
                                i--;
                        }
                }
                // gets user input for destination and moves peice there
                System.out.println("Choose where to move piece, available locations listed below");
                for(int[] i: output) {
                        System.out.print("["+i[0]+","+i[1]+"] ");
                }
                Scanner inp = new Scanner(System.in);
                System.out.println();
                System.out.println("type Row");
                int chosenX =  inp.nextInt();
                System.out.println("type Column");
                int chosenY =  inp.nextInt();
                int[] chosen = {chosenX,chosenY};
                boolean passed = false;
                for(int[] i : output) {
                        if(Arrays.equals(chosen,i)) {
                                passed = true;
                                break;
                        }
                }
                while(!passed) {
                        System.out.println("Invalid coordinate, use coordinates listed");
                        System.out.println("type Row");
                        chosenX =  inp.nextInt();
                        System.out.println("type Column");
                        chosenY =  inp.nextInt();
                        chosen[0] = chosenX;
                        chosen[1] = chosenY;
                        for(int[] i : output) {
                                if(Arrays.equals(chosen,i)) {
                                        passed = true;
                                        break;
                                }
                        }
                }
                board[chosenX][chosenY] = board[x][y];
                board[x][y] = null;

        }

        /**
         * checks if a piece can move onto an opponent piece of eqaul value, in which case the opponent piece is destroyed
         * @param x row of attacking piece
         * @param y column of attacking piece
         * @param targetX row of target piece
         * @param targetY column of target piece
         */
        public void assault(int x, int y, int targetX,int targetY) {
                ArrayList<int[]> destinations = board[x][y].moves(x,y);
                int[] target = {targetX,targetY};
                boolean passed = false;
                for(int[] i: destinations) {
                        if(Arrays.equals(i,target)) {
                                passed = true;
                                break;
                        }
                }
                System.out.println(passed);
                //checks if target piece is in range of attacking piece, then checks whether it can be destroyed
                if (passed && board[x][y].isEnemy(board[targetX][targetY])) {
                        if(board[targetX][targetY].isDestroyed(board[x][y].getVal())) {
                                board[targetX][targetY] = null;
                        }
                }
        }

        /**
         * does siege capture method (if peice is surrounded on 4 sides, it is destroyed).
         * @param x row of target piece
         * @param y column of target piece
         */
        public void siege(int x,int y) {
                //create a temporary board padded on all sides with pieces of opposite color of target piece (this avoids the edge cases when the target is at the edge).
                ArrayList<ArrayList<Men>> padding = new ArrayList<ArrayList<Men>>();
                Men[] pad = {new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite()),new S(0,board[x][y].getOpposite())};
                padding.add(new ArrayList<Men>(Arrays.asList(pad)));
                for(Men[] i: board) {
                        ArrayList<Men> pad2 = new ArrayList<Men>();
                        pad2.add(new S(0,board[x][y].getOpposite()));
                        pad2.addAll(Arrays.asList(i));
                        pad2.add(new S(0,board[x][y].getOpposite()));
                        padding.add(pad2);
                }
                padding.add(new ArrayList<Men>(Arrays.asList(pad)));
                //checks if target piece is surrounded on padded board, where it is destroyed, also updates pyramids.
                if(padding.get(x).get(y+1).getOpposite().equals(board[x][y].getColor()) && padding.get(x+2).get(y+1).getOpposite().equals(board[x][y].getColor()) && padding.get(x+1).get(y).getOpposite().equals(board[x][y].getColor()) && padding.get(x+1).get(y+2).getOpposite().equals(board[x][y].getColor())) {
                        board[x][y].isDestroyed(board[x][y].getVal());
                        if(board[x][y] == whiteP || board[x][y] == blackP) {
                                P output = (P) board[x][y];
                                output.setPieces();
                        }
                        board[x][y] = null;
                }
        }

        /**
         * does deciet capture method (if 2 peices on opposite sides of target add up to target value, the target is destroyed).
         * @param x row of target piece
         * @param y column of target piece
         */
        public void deceit(int x, int y) {
                //checks if piece isnt on corner (deciet is impossible on corner)
                if( !((x==0  && y == 0) || (x==15  && y == 0) || (x==0  && y == 7) || (x==15  && y == 7))) {
                        //checks if we are on top/bottom side of board, where it only tests whether the 2 attackers are left and right
                        if(x == 0 || x == 15) {
                              if(board[x][y].isDestroyed(board[x][y-1].getVal()+board[x][y+1].getVal())) {
                                      board[x][y] = null;
                              }
                        }
                        //checks if we are on left/right side of board, where it only tests whether the 2 attackers are up and down
                        else if(y == 0 || y == 7) {
                                if(board[x][y].isDestroyed(board[x-1][y].getVal()+board[x+1][y].getVal())) {
                                        board[x][y] = null;
                                }
                        }
                        //checks if attackers are both left/right or up/down
                        else {
                                if(board[x][y].isDestroyed(board[x][y-1].getVal()+board[x][y+1].getVal()) || board[x][y].isDestroyed(board[x-1][y].getVal()+board[x+1][y].getVal())) {
                                        board[x][y] = null;
                                }
                        }
                }
        }

        /**
         * returns opposite color
         * @param input the input color
         * @return the opposite of the input color
         */
        public String opposite(String input) {
                if(input.equals("w")) {
                        return "b";
                }
                return "w";
        }
}
