package leetcode;

/**
 * 缀点成线
 *
 * @author yx
 * @create 2019-10-20  10:59
 **/
public class Q5230 {
    public static void main(String[] args) {
        int[][] c = {{1,2},{2,3},{3,4}};
        Q5230 q = new Q5230();
        System.out.println(q.checkStraightLine(c));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int[][] c = coordinates;
        int[] num1 = c[0];
        int[] num2 = c[1];

        if(num1[0]==num2[0]){
            for(int[] num : c){
                if(num[0]!=num1[0]){
                    return false;
                }
            }
        }

        if(num1[1]==num2[1]){
            for(int[] num : c){
                if(num[1]!=num1[1]){
                    return false;
                }
            }
        }
        double a = (num1[1]-num2[1])*1.0/(num1[0]-num2[0]);

        for(int[] num : c){
            double t = (num1[1]-num[1])*1.0/(num1[0]-num[0]);
            if(t!=a){
                return false;
            }
        }

        return true;
    }
}
