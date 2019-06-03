package leetcode;

/**
 * 斐波那契数
 *
 * @author yx
 * @create 2019-06-03  17:28
 **/
public class Q509 {
    //动态规划
    public int fib1(int N) {
        if(N==1) return 1;
        int f1 = 0;
        int f2 = 1;
        int f = 0;

        while(N>1){
            f = f1+f2;
            f1 = f2;
            f2 = f;
            --N;
        }
        return f;
    }

    //递归
    public int fib(int N) {
        if(N<=1) return N;

        return fib(N-1)+fib(N-2);

    }
}
