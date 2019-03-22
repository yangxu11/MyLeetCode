package leetcode;
//删除排序数组中的重复项
public class Q26 {
    //双指针，前一个指针向后走，直到出现不同值出现，将其赋给后一个指针后面的值
    public int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while(j<nums.length)
        {
            if(nums[i]==nums[j])
            {
                j++;
            }
            else
            {
                nums[i+1]=nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}
