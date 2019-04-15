package leetcode;

/**
 * 移动零
 *
 * @author yx
 * @create 2019-04-15  17:49
 **/
public class Q283 {
    //双指针
    public void moveZeroes(int[] nums) {
        if(nums.length<=1) return;
        int start = 0;
        int end  = 0;
        for(;end<nums.length ; end++){
            if(nums[start]==0 && nums[end]!=0){
                nums[start] = nums[end];
                nums[end] = 0;
                start++;
            }
            //初始时，先找到一个start == 0 的情况
            if(nums[start]!=0 && nums[end]==0){
                start = end;
            }
        }

    }
}
