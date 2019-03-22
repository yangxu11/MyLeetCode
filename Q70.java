package leetcode;

import java.util.HashMap;
import java.util.Map;

//爬楼梯
public class Q70 {
    //5ms 12%
    //斐波那契数列，当前n阶的方法数 = n-1阶的方法数（先走1步） + n-2阶的方法数（先走2步）
    //使用map来存储之前的n-1阶的方法数
    public int climbStairs(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        int x = 3;
        while(x<=n){
            map.put(x,map.get(x-1)+map.get(x-2));
            x++;
        }
        return map.get(n);
    }
    //3ms 85%
    //只记录n-1和n-2阶的方法数
    public int climbStairs2(int n) {

        int pre2 = 1;
        int pre1 = 2;

        int x = 3;
        while(x<=n){
            int temp = pre2;
            pre2 = pre1;
            pre1 = temp + pre1;
            x++;
        }
        return n==1 ? 1 : pre1;
    }
}
