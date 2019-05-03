package leetcode.offer;

/**
 * 调整数组顺序使奇数在偶数前面
 *
 * @author yx
 * @create 2019-05-03  11:37
 **/
public class Q13 {
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
