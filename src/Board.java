import java.util.ArrayList;
import java.util.Arrays;

public class Board {

        Men[] whiteP = {new S(36,"w"),new S(25,"w"),new T(16,"w"), new T(9,"w"),new C(4,"w"), new C(1,"w")};
        Men[] blackP = {new S(64,"w"),new S(49,"w"),new T(36,"w"), new T(25,"w"),new C(16,"w")};
        private Men[][] board = {
                {new S(49,"b"),new S(121,"b"),null,null,null,null,new S(225,"b"), new S(361,"b")},
                {new S(28,"b"),new S(66,"b"),new T(36,"b"),new T(30,"b"),new T(56,"b"),new T(64,"b"),new S(120,"b"), new P( new ArrayList<Men>(Arrays.asList(whiteP)),"b")},
                {new T(16,"b"),new T(12,"b"),new C(9,"b"),new C(25,"b"),new C(49,"b"),new C(81,"b"),new T(90,"b"), new T(100,"b")},
                {null,null,new C(3,"b"),new C(5,"b"),new C(7,"b"),new C(9,"b"),null, null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,new C(8,"w"),new C(6,"w"),new C(4,"w"),new C(2,"w"),null, null},
                {new T(81,"w"),new T(72,"w"),new C(64,"w"),new C(36,"w"),new C(16,"w"),new C(4,"w"),new T(6,"w"), new T(9,"w")},
                {new S(153,"w"),new P( new ArrayList<Men>(Arrays.asList(blackP)),"w"),new T(49,"w"),new T(42,"w"),new T(20,"w"),new T(25,"w"),new S(45,"w"), new S(15,"w")},
                {new S(289,"w"),new S(169,"w"),null,null,null,null,new S(81,"w"), new S(25,"w")}
        };
        public void draw() {
                System.out.println("_________________________________________");
                for(Men[] i: board) {
                        System.out.print("|");
                        for(Men j: i) {
                                if(j == null) {
                                        System.out.print("    ");
                                }
                                else if(j.getVal() < 10) {
                                        System.out.print(""+j.getVal()+j.getSymbol()+"  ");
                                }
                                else if(j.getVal() < 100) {
                                        System.out.print(""+j.getVal()+j.getSymbol()+" ");
                                }
                                else{
                                        System.out.print(""+j.getVal()+j.getSymbol());
                                }
                                System.out.print("|");
                        }
                        System.out.println("");
                        System.out.println("_________________________________________");
                }
        }
}
