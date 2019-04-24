package leetcode;

/**
 * 3的幂
 *
 * @author yx
 * @create 2019-04-24  17:48
 **/
public class Q326 {
    public boolean isPowerOfThree(int n) {
        return n>0 && Math.pow(3,19)%n==0;
    }
}
