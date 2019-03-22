package leetcode;
//移除特定元素
public class Q27 {
    //思路同26
    //双指针，后指针遍历，出现val值，将其赋给后指针，只是前后指针有同一起点
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]==val){
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
