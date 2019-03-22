package leetcode;
//矩形面积
public class Q223 {
    //先算出总面积，然后算横轴的交叉，纵轴的交叉， 总面积-交叉的面积
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (A-C)*(B-D) + (E-G)*(F-H);
        int x=0,y=0;
        if(Math.max(A,C) <= Math.min(E,G) || Math.min(A,C)>=Math.max(E,G)) {
            return area;
        } else {
            x = Math.abs(Math.min(Math.max(A,C),Math.max(E,G)) - Math.max(Math.min(A,C),Math.min(E,G)));
        }
        if(Math.max(B,D) <= Math.min(F,H) || Math.min(B,D)>=Math.max(F,H)) {
            return area;
        } else {
            y = Math.abs(Math.min(Math.max(B,D),Math.max(F,H)) - Math.max(Math.min(B,D),Math.min(F,H)));
        }

        return area - x*y;
    }
}
