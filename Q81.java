package leetcode;

public class Q81 {
    //二分查找
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] < nums[mid]) {//左边数组为有序的
                if (target < nums[start] || target > nums[mid]) {//target在mid右边
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {//右边数组是有序的
                if (target < nums[mid] || target > nums[end]) {//target在mid左边
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //防止出现连续数字相同的数组
                start++;
            }
        }
        return false;
    }
}
