import java.util.ArrayList;

public class P extends Men {
    public ArrayList<Men> pieces;
    public P(ArrayList<Men> pieces, String color) {
        super("P",color,0);
        this.pieces = pieces;
        int val = 0;
        for(Men i: pieces) {
            val+=i.getVal();
        }
        super.setVal(val);
    }
    public ArrayList<int[]> moves(int x, int y) {
        ArrayList<int[]> output = new ArrayList<int[]>();
        for(Men i: pieces) {
            output.addAll(i.moves(x,y));
        }
        for(int i = 0; i < output.size();i++) {
            for(int j = i+1; j < output.size();j++) {
                if(output.get(i).equals(output.get(j))) {
                    output.remove(j);
                    j--;
                }
            }
        }
        return output;
    }
}
