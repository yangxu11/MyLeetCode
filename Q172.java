package leetcode;

/**
 * 阶乘后的零
 *
 * @author yx
 * @create 2019-04-03  19:42
 **/
public class Q172 {
    //递归，数5的个数，注意5的幂
    public int trailingZeroes(int n) {
        if(n<5){
            return 0;
        } else{
            return n/5 + trailingZeroes(n/5);
        }
    }
}
