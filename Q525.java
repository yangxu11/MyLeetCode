package leetcode;

import java.util.HashMap;
//连续数组
public class Q525 {
//O(n^2) 超时
//    public int findMaxLength(int[] nums) {
//        int max = 0;
//        for(int i = 0 ; i<nums.length ; i++) {
//            int sum = 0;
//            for(int j=i+1 ; j<nums.length ; j+=2) {
//                sum =sum + nums[j]+nums[j-1];
//                if((j-i+1)/2 == sum) {
//                    max = Math.max(j-i+1 , max);
//                }
//
//            }
//        }
//        return max;
//    }
    public int findMaxLength(int[] nums) {
        int ans = 0,sum = 0;
        for(int i=0;i<nums.length;i++)if(nums[i]==0)nums[i]=-1;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            if(sum == 0) { if(i >= ans) ans = i+1; }
            if(map.get(sum) == null) { map.put(sum,i); continue; }
            int temp = i - map.get(sum);
            if(temp > ans) ans=temp;
        }
        return ans;

    }

}
