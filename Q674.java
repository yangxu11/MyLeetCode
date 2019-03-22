package leetcode;
//最长的连续递增序列
public class Q674 {
    //5ms 70%
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int max=1;
        int count=1;
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i]>nums[i-1]){
                count++;
            } else{
                max = Math.max(max,count);
                count=1;
            }
        }

        return Math.max(max,count);
    }
}
