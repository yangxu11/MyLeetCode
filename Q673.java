package leetcode;

public class Q673 {
    //执行用时: 39 ms, 在Number of Longest Increasing Subsequence的Java提交中击败了79.26% 的用户
    //内存消耗: 44.7 MB, 在Number of Longest Increasing Subsequence的Java提交中击败了0.00% 的用户

    //建立一个dp[n][2]存以nums[i]为结尾的最长子序列的长度和数量，dp[i][0]长度，dp[i][1]数量
    //遍历nums，去Nums[i]时向前遍历，如果nums[j] < nums[i]，看dp[i][0] = max  dp[j][0]+1,dp[i][1] =所有maxlen的和
    //然后更新总的maxlen,num
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=1) return len;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;//{len,num}
        dp[0][1] = 1;
        int max = 1;
        int res = 1;

        for(int i=1 ; i<len ; i++){
            int imax = 1;
            int inum = 1;
            for(int j=i-1 ; j>=0 ; j--){
                if(nums[i] > nums[j]){
                    if(1+dp[j][0] > imax){
                        imax = 1+dp[j][0];
                        inum = dp[j][1];
                    } else if(1+dp[j][0] == imax){
                        inum += dp[j][1];
                    }
                }
            }
            dp[i][0] = imax;
            dp[i][1] = inum;
            if(imax>max){
                res = inum;
                max = imax;
            } else if(imax == max){
                res += inum;
            }
        }

        return res;
    }
}
