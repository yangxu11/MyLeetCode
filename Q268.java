package leetcode;

/**
 * 缺失数字
 *
 * @author yx
 * @create 2019-04-13  12:08
 **/
public class Q268 {
    //位运算，思路同Q136 只出现一次的数字，sum分别与小标i和数组值异或，缺失的数字只会出现一次
    public int missingNumber(int[] nums) {
        int sum=nums.length;
        for(int i=0;i<nums.length;++i){
            sum^=nums[i];
            sum^=i;
        }
        return sum;
    }
    //求和，取差值
    public int missingNumber2(int[] nums) {
        long total = (nums.length * (nums.length+1))/2;

        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        return (int)(total - sum);
    }
}
