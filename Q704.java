package leetcode;
//二分查找
public class Q704 {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid = start+(end-start)/2;

            if(nums[mid]<target){
                start = mid+1;
            } else if(nums[mid]>target){
                end = mid;
            } else{
                return mid;
            }
        }
        return nums[start]==target ? start : -1;
    }
}
