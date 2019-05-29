package leetcode;
//最大连续1的个数
public class Q485 {
    //9ms 50%
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count=0;
        int pre=0;

        for(int i=0 ; i<nums.length ; i++){
            if(pre==0 && nums[i]==0){
                pre=0;
                continue;
            }
            if(nums[i]==0){
                result = Math.max(result,count);
                count=0;
                pre=0;
            } else {
                count++;
                pre=1;
            }
        }
        return Math.max(count,result);
    }
}
