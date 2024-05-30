import java.util.ArrayList;
import java.util.Arrays;
/**
 * handles info for circle piece
 */
public class C extends Men {
    private final int RANGE = 1;
    /**
     * creates a circle piece
     * @param val value of the circle piece
     * @param color side square circle is on
     */
    public C(int val,String color) {
        super("C",color,val);
    }
    /**
     * generates all destinations circle piece can move to
     * @param x the row of the piece
     * @param y the column of the piece
     * @return all destinations circle piece can move to
     */
    public ArrayList<int[]> moves(int x, int y) {
        return super.moves(x,y,RANGE);
    }
}
