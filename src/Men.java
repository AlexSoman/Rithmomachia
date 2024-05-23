public class Men {

    private String symbol;
    private String color;
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

}
