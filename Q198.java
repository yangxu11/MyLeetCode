package leetcode;
//打家劫舍
public class Q198 {
    //执行用时: 5 ms, 在House Robber的Java提交中击败了75.24% 的用户
    //内存消耗: 20.6 MB, 在House Robber的Java提交中击败了87.98% 的用户

    // 当前房屋所能偷取的最大值与之前的i-2,i-3的房屋的最大值有关（不能偷取相邻的），最大值为最后两个房屋的最大值
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(nums[0]+nums[2],nums[1]);

        int t1 = nums[0];
        int t2 = nums[1];
        int t3 = nums[0]+nums[2];
        for(int i=3 ; i<nums.length ; i++){
            int t = nums[i] + Math.max(t1,t2);
            t1 = t2;
            t2 = t3;
            t3 = t;
        }
        return Math.max(t2,t3);
    }
}
