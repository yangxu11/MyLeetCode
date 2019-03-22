package leetcode;
//区域和检索 - 数组不可变
public class Q303 {
    //执行用时: 162 ms, 在Range Sum Query - Immutable的Java提交中击败了80.71% 的用户
    //内存消耗: 32.8 MB, 在Range Sum Query - Immutable的Java提交中击败了99.05% 的用户

    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for(int x= i ; x<=j ; x++){
                sum += nums[x];
            }
            return sum;
        }
    }
}
