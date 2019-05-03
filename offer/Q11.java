package leetcode.offer;

/**
 * 二进制中的1个数
 *
 * @author yx
 * @create 2019-05-03  11:37
 **/
public class Q11 {
    public int NumberOf1(int n) {
        int count =0;
        int index = 32;
        while(index>0){
            if(( n & 1) == 1){
                ++count;
            }
            n >>= 1;
            --index;
        }
        return count;
    }
}
