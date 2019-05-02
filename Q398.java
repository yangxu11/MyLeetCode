package leetcode;

import java.util.Random;

/**
 * 随机索引
 *
 * @author yx
 * @create 2019-05-02  10:56
 **/
public class Q398 {

    //随机数选取时可以使用以下方法
    //计算选取的范围大小，然后rand.nextInt(range)==0 来随机选取
    class Solution {
        private int nums[];
        private Random rmd;
        public Solution(int[] nums) {
            this.nums = nums;
            rmd =new Random();
        }

        public int pick(int target) {
            int res = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (rmd.nextInt(++count) == 0) {
                        res = i;
                    }
                }
            }
            return res;
        }
    }
}
