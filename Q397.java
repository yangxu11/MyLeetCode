package leetcode;

/**
 * 整数替换
 *
 * @author yx
 * @create 2019-05-02  10:47
 **/
public class Q397 {
    //递归
    public int integerReplacement(int n) {
        if(n==1) return 0;
        if(n==Integer.MAX_VALUE) return 32;
        if(n%2 == 0){
            return integerReplacement(n/2)+1;
        } else{
            return Math.min(integerReplacement(n+1),integerReplacement(n-1))+1;
        }
    }
}
