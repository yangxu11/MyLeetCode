package leetcode;
//删除排序数组中的重复元素II
public class Q80 {
    //思路同Q26，双指针
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int fast = 1;
        int slow = 0;
        int count=1;

        while(fast<nums.length){
            if(nums[fast]==nums[slow] && count<2){
                nums[++slow] = nums[fast];
                count++;
            }else if(nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
                count = 1;
            }
            fast++;
        }
        return slow+1;
    }
}
