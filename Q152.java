package leetcode;
//乘积最大子序列
public class Q152 {
//    执行用时: 3 ms, 在Maximum Product Subarray的Java提交中击败了81.89% 的用户
//内存消耗: 21.9 MB, 在Maximum Product Subarray的Java提交中击败了72.59% 的用户

    //保留一个最大的正数，和最小的负数
    //如果遍历的值<0，则imax,imin交换，然后分别它们与当前乘积的最大最小值（防止0）
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i],imax*nums[i]);
            imin = Math.min(nums[i],imin*nums[i]);

            max= Math.max(max,imax);
        }

        return max;
    }
}
