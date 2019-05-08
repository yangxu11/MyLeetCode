package leetcode.offer;

/**
 * 求1+2+3....+n
 *
 * @author yx
 * @create 2019-05-08  19:59
 **/
public class Q47 {
    public int Sum_Solution(int n) {
        if(n==0) return 0;
        return n + Sum_Solution(n-1);
    }
}
