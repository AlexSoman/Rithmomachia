import java.util.ArrayList;

public class P extends Men {
    public ArrayList<Integer> pieces;
    public P(ArrayList<Integer> pieces, String color) {
        super("P",color,0);
        this.pieces = pieces;
        int val = 0;
        for(int i: pieces) {
            val+=i;
        }
        super.setVal(val);
    }
}
