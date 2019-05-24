package leetcode;

/**
 * 汉明距离
 *
 * @author yx
 * @create 2019-05-24  18:04
 **/
public class Q461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while(num>0){
            if((num&1) == 1){
                ++res;
            }
            num>>=1;
        }
        return res;
    }
}
