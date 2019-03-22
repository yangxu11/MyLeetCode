package leetcode;

import java.util.HashMap;
import java.util.Map;

//和为K的子数组
public class Q560 {
    //25ms 95%
    //使用hashmap存储连续数组的和的累积，及其出现的次数
    //如果hashmap中存在sum-k，即当前的sum = k + map中出现过的sum值（presum）  ，这就说明此数组值到presum的数组值的连续子数组和为K
    //则有多少presum的个数，就有多少和为K的连续的子数组
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int result = 0;
        int sum=0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                result += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
    //450ms 10%
    //暴力解法
    public int subarraySum1(int[] nums, int k) {

        int result=0;

        for(int i=0 ; i<nums.length ; i++){
            int target = k-nums[i];
            if(target==0) result++;
            int sum=0;
            for(int j=i+1 ; j<nums.length ; j++){
                sum+=nums[j];
                if(sum==target){
                    result++;
                }
            }
        }
        return result;
    }
}
