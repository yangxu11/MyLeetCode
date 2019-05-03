package leetcode.offer;

/**
 * 数值的整数次方
 *
 * @author yx
 * @create 2019-05-03  10:59
 **/
public class Q12 {
    public static void main(String[] args) {
        Q12 q = new Q12();
        System.out.println(q.Power(2,3));
    }
    public double Power(double base, int exponent) {
        if(exponent==0) return 1;
        int sign = 1;
        if(exponent<0) sign = -1;
        exponent = Math.abs(exponent);
        double res = 1;
        while(exponent > 0){
            double muti = base;
            if(exponent==1){
                res *= base;
                break;
            }
            int times = (int)Math.sqrt(exponent);
            int step = 1;
            for(int i=0 ; i<times ; i++){
                muti *= muti;
                step *= 2;
            }
            res *= muti;
            exponent -= step;
        }
        return sign==1 ? res : 1/res;
    }
}
