package leetcode;

public class Q153 {
    //O(log(n)) 二分法  76%
    public int findMin1(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start < end){
            if(nums[start]<nums[end]) return nums[start];//终止循环，找到后半部分有序数组

            int mid = start+(end-start)/2;
            if(nums[mid]<nums[start]){
                end = mid-1;
                if(nums[end]>=nums[start]){
                    return nums[mid];
                }
            } else {
                start = mid+1;
            }
        }

        return nums[start];
    }
    //O(n)  76%
    public int findMin2(int[] nums) {
        int result=0;
        int pre = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i]<pre){
                return nums[i];
            }
        }
        return pre;
    }
}
