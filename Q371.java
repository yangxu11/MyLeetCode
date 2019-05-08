package leetcode;

/**
 * 两整数相加
 *
 * @author yx
 * @create 2019-05-08  20:03
 **/
public class Q371 {
    //a^b  无进位相加    a&b 每一位的进位
    // a + b =  a^b + a&b<<1 ;
    public int getSum(int a, int b) {
        return b==0 ? a : getSum(a^b,(a&b)<<1);
    }
}
