package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q523 {
    //执行用时: 13 ms, 在Continuous Subarray Sum的Java提交中击败了75.82% 的用户
    //内存消耗: 36.2 MB, 在Continuous Subarray Sum的Java提交中击败了35.71% 的用户

    /**
     在每个索引位置i, 计算当前和对k的mod值, 假设在索引x处, sum[0~x] = m*k + mod_x;
     在索引y处, sum[0~y] = n*k + mod_y; 如果mod_x == mod_y且y-x > 1说明sum[x~y]
     即为一个符合要求的连续子数组, 用map来保存每个mod值对应的索引, 一旦出现新的mod值出现
     在map中, 判断索引差是否大于1.
     注意特殊情况:
     1) 当nums中有连续0, 无论k为何值都是正确的;
     2) 除情况1之外出现k为0都是错误的;
     3) k为负数也是可能的, 但是要将其变为对应正数来求mod.
     此外需要在map中初始化<0,-1>, 其原因在于解决到达某个i时sum恰好可以整除k的情况, 选择-1
     的原因是要求连续子数组长度大于等于2, 这样可以避免第一个数字为0的情况
     **/
    public boolean checkSubarraySum1(int[] nums, int k) {
        if(nums.length < 2) return false;
        for(int i = 0; i < nums.length-1; ++i)
            if(nums[i] == 0 && nums[i+1] == 0) return true;
        if(k == 0) return false;
        if(k < 0) k = -k;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int mod = sum % k;
            if(map.containsKey(mod)) {
                if(i-map.get(mod) > 1)
                    return true;
            }
            else // 不存在再更新
                map.put(mod, i);
        }
        return false;
    }

    //执行用时: 43 ms, 在Continuous Subarray Sum的Java提交中击败了53.69% 的用户
    //内存消耗: 29.1 MB, 在Continuous Subarray Sum的Java提交中击败了57.14% 的用户

    //使用数组来存储以nums[i]为结尾的连续子序列的和，如果出现k的整数倍，return true，否则dp[j] = nums[i] + dp[j]
    public boolean checkSubarraySum2(int[] nums, int k) {
        if(nums.length<=1) return false;

        for(int i = 0; i < nums.length-1; ++i)
            if(nums[i] == 0 && nums[i+1] == 0) return true;
        if(k == 0) return false;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            for(int j=0 ; j<i ; j++){
                int num = dp[j];
                if((num+nums[i])%k == 0){
                    return true;
                } else {
                    dp[j] = num+nums[i];
                }
            }
            dp[i] = nums[i];
        }

        return false;
    }
}
