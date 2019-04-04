package leetcode;

/**
 * 数字范围按位与
 *
 * @author yx
 * @create 2019-04-04  20:50
 **/
public class Q201 {
    /**
     * 最低位的1或0表示奇、偶数，若区间[m,n]包含>=2个数字，则最低位必为0
     * 因此:区间长度>1,即m!=n,能用于确定按位与的最低位等于0 ----推出----> while循环的判断条件
     *      区间长度=1,即m==n
     */
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while(m!=n) {
            if(m==0)
                return 0;
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return m<<cnt;
    }
}
