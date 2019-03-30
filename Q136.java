package leetcode;

/**
 * 只出现一次的数字
 *
 * @author yx
 * @create 2019-03-30  11:41
 **/
public class Q136 {
    //异或运算
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = 0;
        for(int i=0 ; i<nums.length ; i++){
            res ^= nums[i];
        }
        return res;

    }
}
