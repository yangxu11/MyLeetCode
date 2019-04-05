package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author yx
 * @create 2019-04-05  10:31
 **/
public class Q202 {
    public boolean isHappy(int n) {
        if(n==0) {
            return false;
        }
        Set<Integer> set = new HashSet();
        while(n!=1){
            int sum = 0;
            while(n>0){
                sum += (n%10) * (n%10);
                n /= 10;
            }
            if(!set.add(sum)) {
                return false;
            }
            n = sum;
        }
        return true;
    }
}
