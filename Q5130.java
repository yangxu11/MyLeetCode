package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 等价多米诺骨牌对的数量
 *
 * @author yx
 * @create 2019-07-21  16:28
 **/
public class Q5130 {
    public int numEquivDominoPairs(int[][] dominoes) {

        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<dominoes.length ; i++){
            int num1 = 40000*dominoes[i][0] + dominoes[i][1];
            int num2 = 40000*dominoes[i][1] + dominoes[i][0];
            if(num1!=num2){
                res += map.getOrDefault(num1,0);
                map.put(num1,map.getOrDefault(num1,0)+1);
                map.put(num2,map.getOrDefault(num2,0)+1);
            } else{
                res += map.getOrDefault(num1,0);
                map.put(num2,map.getOrDefault(num2,0)+1);
            }
        }

        return res;
    }
}
