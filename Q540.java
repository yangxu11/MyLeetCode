package leetcode;

/**
 * 有序数组中唯一的元素
 *
 * @author yx
 * @create 2019-06-09  19:56
 **/
public class Q540 {
    //end为偶数
    //mid必为偶数
    //在单一元素前,偶数i nums[i] = nums[i+1]
    //在单一元素后,偶数j nums[j] != nums[j+1]
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid =start +  (end-start)/2;

            if(mid % 2 !=0){
                mid--;
            }
            if(nums[mid] != nums[mid+1]){
                end = mid;
            } else{
                start = mid+2;
            }
        }
        return nums[start];
    }
}
