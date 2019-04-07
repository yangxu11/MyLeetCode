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

        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    private int rob(int[] nums,int start,int end){
        int len = end-start+1;
        if(len==1) return nums[start];
        if(len==2) return Math.max(nums[start],nums[end]);
        int m1 = 0;
        int m2 = nums[start];
        int m3 = nums[start+1];
        for(int i=start+2 ; i<=end ; i++){
            int m = Math.max(m1,m2) + nums[i];
            m1 = m2;
            m2 = m3;
            m3 = m;
        }
        return Math.max(m2,m3);
    }
}
