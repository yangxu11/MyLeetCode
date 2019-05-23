package leetcode;

/**
 * 最小移动次数使数组值相等
 *
 * @author yx
 * @create 2019-05-23  19:42
 **/
public class Q453 {
    //n-1个数+1，相当于只有一个数-1
    public int minMoves(int[] nums) {
        if(nums.length<=1) return 0;
        long min = Integer.MAX_VALUE;
        long sum = 0;
        for(int num : nums){
            sum += num;
            min = Math.min(min,num);
        }

        return (int)(sum - min*nums.length);

    }
}
