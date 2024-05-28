import java.util.ArrayList;
import java.util.Arrays;

public class T extends Men {
    private final int RANGE = 2;
    public T(int val,String color) {
        super("T",color,val);
    }
    public ArrayList<int[]> moves(int x, int y) {
        int[][] moves = {{x-RANGE,y-RANGE},{x,y-RANGE},{x+RANGE,y-RANGE},{x-RANGE,y},{x,y},{x+RANGE,y},{x-RANGE,y+RANGE},{x,y+RANGE},{x+RANGE,y+RANGE}};
        ArrayList<int[]> output = new ArrayList<int[]>(Arrays.asList(moves));
        for(int i = 0; i < output.size();i++) {

            if(output.get(i)[0] < 0 || output.get(i)[0] >= 8 || output.get(i)[1] < 0 || output.get(i)[1] >= 16) {
                output.remove(i);
                i--;
            }
        }
        return output;
    }
}
