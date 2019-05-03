package leetcode.offer;

/**
 * 斐波那契数列
 *
 * @author yx
 * @create 2019-05-03  11:35
 **/
public class Q7 {
    public int Fibonacci(int n) {
        if(n==0 || n==1) return n;
        int n1 = 0;
        int n2 = 1;
        for(int i=2 ; i<=n ; i++){
            n2 = n1+n2;
            n1 = n2 - n1;
        }
        return n2;
    }
}
