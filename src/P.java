import java.util.ArrayList;
import java.util.Arrays;
/**
 * handles info for pryamid piece
 */
public class P extends Men {
    public ArrayList<Men> pieces;
    /**
     * creates a square piece
     * @param pieces pieces in pyramid
     * @param color side pryamid  piece is on
     */
    public P(ArrayList<Men> pieces, String color) {
        super("P",color,0);
        this.pieces = pieces;
        int val = 0;
        for(Men i: pieces) {
            val+=i.getVal();
        }
        super.setVal(val);
    }

    /**
     * sets pieces list to empty if pyramid is captured via siege
     */
    public void setPieces() {
        pieces = new ArrayList<Men>();
    }

    /**
     * gets pieces in pyramid
     * @return pieces in pyramid
     */
    public ArrayList<Men> getPieces() {
        return pieces;
    }
    /**
     * generates all destinations pyramid piece can move to
     * @param x the row of the piece
     * @param y the column of the piece
     * @return all destinations pyramid piece can move to
     */
    public ArrayList<int[]> moves(int x, int y) {
        // adds all possible destinations the pyramid pieces can go to
        ArrayList<int[]> output = new ArrayList<int[]>();
        for(Men i: pieces) {
            output.addAll(i.moves(x,y));
        }
        //weeds out dupicates and returns whats left.
        for(int i = 0; i < output.size();i++) {
            for(int j = i+1; j < output.size();j++) {
                if(Arrays.equals(output.get(i),output.get(j))) {
                    output.remove(j);
                    j--;
                }
            }
        }
        return output;
    }

    /**
     * recalculates value of pyramid and updates it
     * @return value of pyramid
     */
    public int getVal() {
        //adds up all pieces value and returns sum
        int val = 0;
        for(Men i: pieces) {
            val+=i.getVal();
        }
        super.setVal(val);
        return super.getVal();
    }

    /**
     * checks if pyramid peice can be destroyed
     * @param val the value that will be used to destroy the piece
     * @return whether pyramid piece was FULLY destroyed
     */
    public boolean isDestroyed(int val) {
        //checks if one of its pieces can be destroyed, then checks whether it itself can be destroyed.
        for(Men i: pieces) {
            if(i.isDestroyed(val)) {
                pieces.remove(i);
                this.getVal();
                return pieces.isEmpty();
            }
        }
        return super.isDestroyed(val);
    }
}
