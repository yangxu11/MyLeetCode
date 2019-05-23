package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数之和II
 *
 * @author yx
 * @create 2019-05-23  19:56
 **/
public class Q454 {
    //分为两个部分计算
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        if(len == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();

        int res = 0;

        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                int num = C[i] + D[j];
                if(map.containsKey(0-num)){
                    res += map.get(0-num);
                }
            }
        }
        return res;
    }
}
