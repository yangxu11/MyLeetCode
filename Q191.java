package leetcode;

/**
 * 位1的个数
 *
 * @author yx
 * @create 2019-04-03  20:44
 **/
public class Q191 {
    public int hammingWeight(int n) {
        int res = 0;
        int i=32;
        while(i>0){
            int x = n&1;
            if( x == 1){
                res++;
            }
            n>>=1;
            --i;
        }
        return res;
    }
}
