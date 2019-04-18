package leetcode;
//区域和检索 - 数组不可变
public class Q303 {
    //执行用时: 162 ms, 在Range Sum Query - Immutable的Java提交中击败了80.71% 的用户
    //内存消耗: 32.8 MB, 在Range Sum Query - Immutable的Java提交中击败了99.05% 的用户

    class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for(int i=0 ; i<nums.length ; i++){
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            if(i==0){
                return sums[j];
            } else{
                return sums[j] - sums[i-1];
            }
        }
    }
}
