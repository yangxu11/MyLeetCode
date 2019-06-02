package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 *
 * @author yx
 * @create 2019-06-02  10:21
 **/
public class Q506 {

    //数组记录所有数字的下标
    public String[] findRelativeRanks1(int[] nums) {
        int max = 0;
        for(int i=0 ; i<nums.length ; i++){
            max = Math.max(nums[i],max);
        }

        int[] dp = new int[max+1];

        for(int i=0 ; i<nums.length ; i++){
            dp[nums[i]] = i+1;
        }
        String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        String[] res = new String[nums.length];

        for(int i=max,flag=1 ; i>=0 ; i--){
            if(dp[i]>0){
                switch(flag){
                    case 1 : res[dp[i]-1] = "Gold Medal";break;
                    case 2 : res[dp[i]-1] = "Silver Medal";break;
                    case 3 : res[dp[i]-1] = "Bronze Medal";break;
                    default: res[dp[i]-1] = String.valueOf(flag);
                }

                ++flag;
            }
        }

        return res;
    }

    //map + 排序  map记录下标
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i],i);
        }

        Arrays.sort(nums);

        String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        String[] res = new String[nums.length];
        int index = 0;
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(index<3){
                res[map.get(nums[i])] = medal[index];
            } else{
                res[map.get(nums[i])] = String.valueOf(index+1);
            }
            ++index;
        }

        return res;
    }
}
