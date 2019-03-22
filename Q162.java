package leetcode;
//寻找峰值
public class Q162 {
    //60%  二分法寻找
    //如果end值>mid值  则右边存在峰值
    //如果start值>mid值  则左边存在峰值
    //如果 mid>=start  >=end  则start和end向mid逼近
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while(start<=end){
            int mid = start + (end - start)/2;
            if(start==end) return start;
            if(nums[mid] < nums[end]){
                start = mid + 1;
                continue;
            } else if(nums[start] > nums[mid]){
                end = mid - 1;
                continue;
            } else {
                start++;
                end--;
            }
        }
        return nums[start] > nums[end] ? start : end;//防止逼近时start,end错位 如{2，1}
    }
}
