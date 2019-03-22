package leetcode;
//打家劫舍II
public class Q213 {
    //执行用时: 4 ms, 在House Robber II的Java提交中击败了97.82% 的用户
    //内存消耗: 26 MB, 在House Robber II的Java提交中击败了14.93% 的用户

    //同Q198 打家劫舍
    //在有环的情况下，
    //如果取第一家，则最后一家不可能取到，这样把环拆开，数组为[0,nums.length-2]不包括最后一个
    //如果取第二家，则第一家不可能取到，把环拆开，数组为[1,nums.length-1]不包括第一个
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        //取第一个房子，最后一个取不到
        int m1 = 0;
        int m2 = nums[0];
        int m3 = nums[1];
        int result = Math.max(nums[0],nums[1]);
        for(int i=3 ; i<nums.length ; i++){
            int m = Math.max(m1,m2) + nums[i-1];
            result = Math.max(result,m);
            m1 = m2;
            m2 = m3;
            m3 = m;
        }
        //取第二个房屋，第一个取不到
        m1 = 0;
        m2 = nums[1];
        m3 = nums[2];
        for(int i=4 ; i<nums.length+1 ; i++){
            int m = Math.max(m1,m2) + nums[i-1];
            result = Math.max(result,m);
            m1 = m2;
            m2 = m3;
            m3 = m;
        }

        return result;
    }
}
