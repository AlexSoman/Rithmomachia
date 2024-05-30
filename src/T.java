import java.util.ArrayList;
import java.util.Arrays;
/**
 * handles info for triangle piece
 */
public class T extends Men {
    private final int RANGE = 2;
    /**
     * creates a triangle piece
     * @param val value of the triangle piece
     * @param color side circle piece is on
     */
    public T(int val,String color) {
        super("T",color,val);
    }
    /**
     * generates ll destinations triangle piece can move to
     * @param x the row of the piece
     * @param y the column of the piece
     * @return all destinations triangle piece can move to
     */
    public ArrayList<int[]> moves(int x, int y) {
        return super.moves(x,y,RANGE);
    }
}
