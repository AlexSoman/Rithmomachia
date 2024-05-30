import java.util.ArrayList;
import java.util.Arrays;

/**
 * handles info for square piece
 */
public class S extends Men{
    private final int RANGE = 3;

    /**
     * creates a square piece
     * @param val value of the square piece
     * @param color side square piece is on
     */
    public S(int val,String color) {
        super("S",color,val);
    }

    /**
     * generates all destinations square piece can move to
     * @param x the row of the piece
     * @param y the column of the piece
     * @return all destinations square piece can move to
     */
    public ArrayList<int[]> moves(int x, int y) {
        return super.moves(x,y,RANGE);
    }
}
