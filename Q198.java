package leetcode;
//打家劫舍
public class Q198 {
    //执行用时: 5 ms, 在House Robber的Java提交中击败了75.24% 的用户
    //内存消耗: 20.6 MB, 在House Robber的Java提交中击败了87.98% 的用户

    // 当前房屋所能偷取的最大值与之前的i-2,i-3的房屋的最大值有关（不能偷取相邻的），取其中的最大值加上当前值为最大
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length == 1) return nums[0];

        int m1 = 0;
        int m2 = nums[0];
        int m3 = nums[1];
        int result = Math.max(nums[0],nums[1]);
        for(int i=3 ; i<nums.length+1 ; i++){
            int m = Math.max(m1,m2) + nums[i-1];
            result = Math.max(result,m);
            m1 = m2;
            m2 = m3;
            m3 = m;
        }
        return result;
    }
}
