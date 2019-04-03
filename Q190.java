package leetcode;

/**
 * 颠倒二进制位
 *
 * @author yx
 * @create 2019-04-03  20:40
 **/
public class Q190 {
    public int reverseBits(int n) {
        int ans=0;
        int i=32;
        while(i>0){
            ans<<=1;
            ans+=n&1;
            n>>=1;
            i--;
        }
        return ans;
    }
}
