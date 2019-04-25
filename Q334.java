package leetcode;

/**
 * 递增的三元子序列
 *
 * @author yx
 * @create 2019-04-25  20:10
 **/
public class Q334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int num1 = nums[0];
        int num2 = Integer.MAX_VALUE;

        for(int i=1 ; i<nums.length ; i++){
            if(nums[i]>num2){
                return true;
            }
            if(nums[i]<num1){
                num1 = nums[i];
            } else if(nums[i] > num1 && nums[i]<num2){
                num2 = nums[i];
            }
        }
        return false;
    }
}
