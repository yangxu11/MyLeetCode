package leetcode;
//搜索旋转排序数组
public class Q81 {
    //二分查找，画图逐个分析各种情况
    public boolean search1(int[] nums, int target) {
        if(nums.length == 0) return false;
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[start]==target||nums[end] == target || nums[mid]==target) return true;
            if(nums[start]<target){//target落在左半区间
                if(nums[mid] < nums[start]){//mid在右半区间
                    end = mid-1;
                } else if(nums[mid] > nums[start]){//mid在左半区间，正常二分
                    if(nums[mid]>target){
                        end = mid-1;
                    } else if(nums[mid]<target){
                        start = mid+1;
                    } else {
                        return true;
                    }
                } else{//mid与nums[start]相同可能在左也可能在右
                    if(nums[mid]==nums[end]){
                        start++;
                        end--;
                    } else{
                        start = mid+1;
                    }
                }
            } else {//target落在右半区间
                if(nums[mid]>nums[start]){
                    start = mid+1;
                } else if(nums[mid] <nums[start]){
                    if(nums[mid]>target){
                        end = mid-1;
                    } else if(nums[mid]<target){
                        start = mid+1;
                    } else {
                        return true;
                    }
                } else{
                    if(nums[mid]==nums[end]){
                        start++;
                        end--;
                    } else{
                        start = mid+1;
                    }
                }
            }
        }
        return nums[start]==target;
    }

    //二分查找
    public boolean search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] < nums[mid]) {//左边数组为有序的
                if (target < nums[start] || target > nums[mid]) {//target在mid右边
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {//右边数组是有序的
                if (target < nums[mid] || target > nums[end]) {//target在mid左边
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //防止出现连续数字相同的数组
                start++;
            }
        }
        return false;
    }
}
