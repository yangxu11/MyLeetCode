package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//最大整除子集
public class Q368 {
//执行用时: 51 ms, 在Largest Divisible Subset的Java提交中击败了31.79% 的用户
//内存消耗: 25.8 MB, 在Largest Divisible Subset的Java提交中击败了36.36% 的用户

    //思路同解法2
    //不同的是，使用两个数组存储之前的信息，count[i]存储最长的长度，pre[i]存储该位置最长序列之前数组的坐标
    //最后找到最长index后，直接根据pre[]记录的坐标一步步往前推
    public List<Integer> largestDivisibleSubset1(int[] nums) {
        int n = nums.length;
        int[] count = new int[n], pre = new int[n];
        int index = -1, max = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            count[i] = 1;
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    if(count[i] < 1 + count[j]){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(max < count[i]){
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
    //执行用时: 50 ms, 在Largest Divisible Subset的Java提交中击败了35.10% 的用户
    //内存消耗: 29.3 MB, 在Largest Divisible Subset的Java提交中击败了13.64% 的用户

    //先对数组进行排序
    //建立数组dp[]来存储以nums[i]为结尾的最长的list,
    // 遍历nums[i] ,从头寻找能nums[i]%nums[j]==0，然后找出对应的最长的dp[j]，将nums[i]加入其后
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        if(nums.length==0) return new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[nums.length];
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        dp[0] = first;
        int len = 1;
        int index = 0;

        for(int i=1 ; i<nums.length ; i++){
            List<Integer> list = null;
            int max = 1;
            int pos = -1;
            for(int j=i-1 ; j>=0 ; j--){
                if(nums[i] % nums[j]==0){
                    if(dp[j].size() >= max){
                        pos = j;
                        max = dp[j].size()+1;
                    }
                }
            }
            if(pos==-1){
                list = new ArrayList<>();
            } else {
                list = new ArrayList<>(dp[pos]);
            }
            list.add(nums[i]);
            dp[i] = list;

            if(list.size()>len){
                index = i;
                len = list.size();
            }
        }
        return dp[index];
    }
}
