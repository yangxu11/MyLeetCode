package leetcode;
//摆动序列
public class Q376 {
    //执行用时: 0 ms, 在Wiggle Subsequence的Java提交中击败了100.00% 的用户
    //内存消耗: 24.9 MB, 在Wiggle Subsequence的Java提交中击败了4.76% 的用户

    //计算序列中有多少个波峰和波谷
    //使用up记录上升，down记录下降，如果数组下降down = up+1完成一个波峰 如果数组上升up = down+1 完成一个波谷
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    //方法2 贪心
    //前状态为上升时，如果目前状态还是上升则保留当前值（最大）
    //前状态为下降时，如果目前状态还是下降则保留当前值（最小）
    public int wiggleMaxLength2(int[] nums) {
        if(nums.length<=1) return nums.length;
        if(nums.length==2){
            return nums[0]==nums[1] ? 1 : 2;
        }
        int res = 2;
        int state=0;
        int cur = nums[0];
        int index = 1;
        while(index<nums.length && nums[index] == cur){
            index++;
        }
        if(index==nums.length) return 1;
        state = nums[index]-nums[0] > 0 ? 1 : -1;
        cur = nums[index];

        for(int i=index+1 ; i<nums.length ; i++){
            if((nums[i]-cur) * state < 0){
                ++res;
                state = -1*state;
            }
            cur = nums[i];
        }
        return res;
    }
}
