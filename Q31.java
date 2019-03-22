package leetcode;
//下一个排列
public class Q31 {
    //从末尾开始寻找第一个出现上升的i，nums[i]<nums[i+1]
    //然后再从末尾开始找第一个j,nums[j]>nums[i]
    //这样i,j的值调换，剩下i之后的值升序排列即为下一个排列，升序排列即为reverse，i之后的数组必为降序排序
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
