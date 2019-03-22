package leetcode;
//最长上升子序列
public class Q300 {
    //执行用时: 1 ms, 在Longest Increasing Subsequence的Java提交中击败了95.50% 的用户
    //内存消耗: 20.7 MB, 在Longest Increasing Subsequence的Java提交中击败了56.54% 的用户

    /**思路：
     dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
     由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
     对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
     1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
     数组尾部, 并将最长递增序列长度maxL加1
     2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
     **/
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] b = new int[nums.length + 1];//b[1]到b[nums.length]存储
        b[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > b[len]) {
                b[++len] = nums[i];


            } else {
                int start = 1, end = len;
                int mid = 0;
                while (start <= end) {
                    mid = start + (end - start) / 2;
                    if (b[mid] < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                b[start] = nums[i];
                len = Math.max(start, len);

            }
        }
        return len;
    }
    //执行用时: 43 ms, 在Longest Increasing Subsequence的Java提交中击败了19.72% 的用户
    //内存消耗: 21.3 MB, 在Longest Increasing Subsequence的Java提交中击败了26.18% 的用户

    //动态规划
    //遍历到i时，向前寻找小于nums[n]的数组值，取其res[j]（下标j对应的最长上升序列），找到最大的max=res[j]
    //res[i]= 1+max;然后比较输出最大值
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] res = new int[nums.length];
        int result = 1;

        res[0] = 1;

        for(int i=1 ; i<nums.length ; i++){
            res[i] = 1;
            int max=0;
            for(int j=i-1 ; j>=0 ; j--){
                if(nums[j]<nums[i]){
                    max = Math.max(max,res[j]);
                }
                if(j<=max) break;
            }
            res[i] = 1+max;
            result = Math.max(res[i],result);
        }
        return result;

    }
}
