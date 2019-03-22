package leetcode;
// 在排序数组中查找元素的第一个和最后一个位置
public class Q34 {
    //二分查找，先确定该元素的一个的位置，然后两边向中间逼近
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int[] res = new int[2];
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            if(nums[start]==target && nums[end]==target){
                res[0]=start;
                res[1]=end;
                return res;
            }
            int mid = start+(end-start)/2;

            if(nums[mid]>target){
                end = mid-1;
            } else if(nums[mid]<target){
                start = mid+1;
            } else{
                if(nums[start]<target) start++;
                if(nums[end]>target) end--;
            }
        }
        return nums[start]==target ? new int[]{start,start} : new int[]{-1,-1};
    }
}
