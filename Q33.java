package leetcode;
//搜索旋转排序数组
public class Q33 {
    //画出区间图，认真分析
    //1、start>target target在右区间  判断mid>start mid在左区间 start = mid+1 如果mid在右区间（有序区间），正常二分
    //2、start<target target在左区间  判断mid<start mid在左区间 end = mid-1  如果mid在左区间，正常二分
    //3、start==target return start
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[start]==target) return start;
            if(nums[end]==target) return end;
            if(nums[start]>target){
                if(nums[mid]>nums[start]){
                    start = mid+1;
                } else {
                    if(nums[mid]>target){
                        end = mid-1;
                    } else if(nums[mid]<target){
                        start = mid+1;
                    } else{
                        return mid;
                    }
                }
            } else {
                if(nums[mid]<nums[start]){
                    end = mid-1;
                } else {
                    if(nums[mid]>target){
                        end = mid-1;
                    } else if(nums[mid]<target){
                        start = mid+1;
                    } else{
                        return mid;
                    }
                }
            }
        }
        return nums[start]==target ? start : -1;
    }
}
