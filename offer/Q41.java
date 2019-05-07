package leetcode.offer;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 *
 * @author yx
 * @create 2019-05-07  20:01
 **/
public class Q41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        ArrayList<Integer> cur = new ArrayList<>();
        int num = 0;
        int i=1;
        while(i<sum){
            while(num < sum && i<sum){
                cur.add(i);
                num += i;
                ++i;
            }
            //if(sum==num) res.add(new ArrayList<>(cur));
            while(num >= sum){
                if(sum==num) {
                    res.add(new ArrayList<>(cur));
                }
                num -= cur.get(0);
                cur.remove(0);
            }
        }
        return res;
    }
}
