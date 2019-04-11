package leetcode;

/**
 * 除自身以外数组的乘积
 *
 * @author yx
 * @create 2019-04-11  17:00
 **/
public class Q238 {
    //先从左到右累乘，res[i]得到的时当前数字左边的所有乘积
    //然后从右往左累乘，res[i]在原基础上乘以右边所有数字的乘积
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int num=1;
        for(int i=0 ; i<len ; i++){
            res[i] = num;
            num *= nums[i];
        }
        num = 1;
        for(int i=len-1 ; i>=0 ; i--){
            res[i] *= num;
            num *= nums[i];
        }
        return res;
    }
}
