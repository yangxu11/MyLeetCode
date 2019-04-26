package leetcode;

/**
 * 4的幂
 *
 * @author yx
 * @create 2019-04-26  17:39
 **/
public class Q342 {
    //num &(num - 1) 保证是2的幂
    //(num & 0x55555555) != 0保证偶数位有1
    public boolean isPowerOfFour(int num) {
        return ((num & 0x55555555) != 0) && ((num & (num - 1)) == 0);
    }
}
