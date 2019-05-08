package leetcode.offer;

/**
 * 不用加减乘除做加法
 *
 * @author yx
 * @create 2019-05-08  20:06
 **/
public class Q48 {
    //a^b  无进位相加    a&b 每一位的进位
    // a + b =  a^b + a&b<<1 ;
    public int Add(int num1,int num2) {
        return num2 == 0 ? num1 : Add(num1^num2,(num1&num2)<<1);
    }
}
