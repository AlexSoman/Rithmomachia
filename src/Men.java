import java.util.ArrayList;
import java.util.Arrays;

/**
 * superclass of all pieces, handles pieces.
 */
public class Men {

    private final String symbol;
    private final String color;
    private int val;
    private static int captures;

    /**
     * constructs piece
     * @param symbol what type of piece it is
     * @param color what side piece is on
     * @param val what value piece has
     */
    public Men(String symbol,String color,int val) {
        this.symbol = symbol;
        this.color = color;
        this.val = val;
        captures = 0;
    }

    /**
     * returns the amount of captures that have occured
     * @return the amount of captures that have occured
     */
    public int getCaptures() {
        return captures;
    }

    /**
     * updates the value of a piece (used for prymaid when it loses a piece)
     * @param val the new value the piece should be updated to.
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * returns the value of the piece
     * @return the value of the piece
     */
    public int getVal() {
        return val;
    }

    /**
     * returns te symbol of the piece
     * @return the symbol of the piece
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * returns the color of the piece
     * @return the color of the piece
     */
    public String getColor() {
        return color;
    }

    /**
     * returns the color opposite to color of the piece
     * @return the color opposite to color of the piece
     */
    public String getOpposite() {
        if(color.equals("w")) {
            return "b";
        }
        return "w";
    }

    /**
     * implemented in other classes, returns all possible destinations the piece could land (does not check for occupation).
     * @param x the row of the piece
     * @param y the column of the piece
     * @return a list of all possible destinations
     */
    public ArrayList<int[]> moves(int x, int y) {
        return null;
    }

    /**
     * returns all possible destinations the piece could land (does not check for occupation).
     * @param x the row of the piece
     * @param y the column of the piece
     * @param RANGE how far the piece can go
     * @return a list of all possible destinations
     */
    public ArrayList<int[]> moves(int x, int y, int RANGE) {
        //generates all possible destinations
        int[][] moves = {{x-RANGE,y-RANGE},{x,y-RANGE},{x+RANGE,y-RANGE},{x-RANGE,y},{x,y},{x+RANGE,y},{x-RANGE,y+RANGE},{x,y+RANGE},{x+RANGE,y+RANGE}};
        ArrayList<int[]> output = new ArrayList<int[]>(Arrays.asList(moves));
        for(int i = 0; i < output.size();i++) {
            //weeds out destinations that are out of bounds
            if(output.get(i)[0] < 0 || output.get(i)[0] >= 16 || output.get(i)[1] < 0 || output.get(i)[1] >= 8) {
                output.remove(i);
                i--;
            }
        }
        return output;
    }

    /**
     * checks if piece can be destroyed, if it can, it adds to capture
     * @param val the value that will be used to destroy the piece
     * @return whether the piece can be destroyed or not
     */
    public boolean isDestroyed(int val) {
        if(this.val == val) {
            captures++;
            return true;
        }
        return false;
    }

    /**
     * checks if other piece is on different side
     * @param target the other piece
     * @return whether it is on the different side.
     */
    public boolean isEnemy(Men target) {
        return (target.getColor().equals("b") && color.equals("w")) || (target.getColor().equals("w") && color.equals("b"));
    }
}
