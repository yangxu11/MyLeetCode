package leetcode;

/**
 * 最少是其他数字两倍的最大数
 *
 * @author yx
 * @create 2019-07-21  16:22
 **/
public class Q747 {
    public int dominantIndex(int[] nums) {
        if(nums.length==1) return 0;

        int max = 0;
        int index = 0;

        int second = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] > max){
                if(max>second){
                    second = max;
                }
                index = i;
                max = nums[i];
            } else{
                if(nums[i]>second){
                    second = nums[i];
                }
            }
        }

        return max>=2*second ? index : -1;
    }
}
