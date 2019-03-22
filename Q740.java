package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//删除与获得点数
public class Q740 {
    //执行用时: 7 ms, 在Delete and Earn的Java提交中击败了77.05% 的用户
    //内存消耗: 39.4 MB, 在Delete and Earn的Java提交中击败了0.00% 的用户

    //同打家劫舍问题
    //建立数组a[]（长度为数组的最大值）存储每个数字出现的次数，建立数组dp[nums[i]]存储以nums[i]为结尾的子数组的最大值
    //dp[n] = max(dp[n-1],dp[n-2]+a[n]*n)
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int max = 0;
        for(int num: nums){
            if(num > max){
                max = num;
            }
        }
        int[] a = new int[max + 1];
        for(int num: nums){
            a[num] ++;
        }
        int[] dp = new int[max + 1];
        dp[1] = a[1];
        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + a[i] * i);
        }
        return dp[max];
    }
//方法2
    public int deleteAndEarn2(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<len ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int pre = map.get(nums[0]) * nums[0];
        int index = map.get(nums[0]);
        int ppre = 0;
        int res = pre;


        for(int i=index ; i<len ;){
            if(nums[i] == nums[i-1]+1){
                res = Math.max(map.get(nums[i]) * nums[i] + ppre,pre);
            } else{
                res = pre + map.get(nums[i]) * nums[i];
            }
            ppre = pre;
            pre = res;
            i += map.get(nums[i]);
        }

        return res;

    }
}
