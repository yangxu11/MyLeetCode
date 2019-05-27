package leetcode;

/**
 * 数字的补码
 *
 * @author yx
 * @create 2019-05-27  21:13
 **/
public class Q476 {
    public int findComplement(int num) {
        int res = 0;
        int step = 1;
        while(num>0){
            if((num&1) == 0){
                res += step;
            }
            step<<=1;
            num>>=1;
        }
        return res;
    }
}
