package leetcode;
//搜索插入位置
public class Q35 {
    //二分法，注意最后的值与target的比较
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>target){
                end = mid;
            } else if(nums[mid]<target){
                start = mid+1;
            } else{
                return mid;
            }
        }
        return nums[start]>=target ? start : start+1;
    }
}
