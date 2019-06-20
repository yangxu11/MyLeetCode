package leetcode;

/**
 * 平方数之和
 *
 * @author yx
 * @create 2019-06-20  20:03
 **/
public class Q633 {
    public boolean judgeSquareSum(int c) {
        int end = (int)Math.sqrt(c);
        int start = 0;
        while(start<=end){
            int num = start*start + end*end;
            if(num>c){
                end--;
            } else if(num < c){
                start++;
            } else{
                return true;
            }
        }
        return false;
    }
}
