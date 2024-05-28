import java.util.ArrayList;

public class Men {

    private final String symbol;
    private final String color;
    private int val;
    private static int captures;
    public Men(String symbol,String color,int val) {
        this.symbol = symbol;
        this.color = color;
        this.val = val;
        captures = 0;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public int getVal() {
        return val;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getColor() {
        return color;
    }
    public ArrayList<int[]> moves(int x, int y) {
        return null;
    }
}
