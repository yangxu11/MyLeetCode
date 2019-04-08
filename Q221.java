package leetcode;
//最大正方形
public class Q221 {
    //执行用时: 20 ms, 在Maximal Square的Java提交中击败了16.92% 的用户
    //内存消耗: 37.3 MB, 在Maximal Square的Java提交中击败了16.18% 的用户

    //从头遍历，如果是边界（最上面和最左面），最大为1
    //不是边界，如果值为1，找到i-1 j-1, i j-1 , i-1 j中的最小值+1则为以该点为右下角的正方形的最大值，
    //比较输出最大
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int xlen = matrix.length;
        if(xlen==0) return 0;
        int ylen = matrix[0].length;
        if(ylen==0) return 0;
        int[][] dp = new int[xlen][ylen];
        for(int i=0 ; i<xlen ; i++){
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]==1) result = 1;
        }

        for(int i=0 ; i<ylen ; i++){
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]==1) result = 1;
        }
        for(int i=1 ; i<matrix.length ; i++){
            for(int j=1 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    result = Math.max(result,dp[i][j]);
                }

            }
        }
        return result*result;
    }
    //执行用时: 13 ms, 在Maximal Square的Java提交中击败了68.53% 的用户
    //内存消耗: 30.2 MB, 在Maximal Square的Java提交中击败了60.29% 的用户
    //寻找是否存在边长为n的正方形（给定左上角和边长，判断其中是否有0），最后给出n的最大值
    public int maximalSquare2(char[][] matrix) {
        int M = matrix.length;
        if (M == 0) {
            return 0;
        }
        int N = matrix[0].length;
        int canMax = Math.min(M, N);
        int max = 0;
        for (int i = 0; i < M - max; i++) {
            for (int j = 0; j < N - max; j++) {
                while (isSquare(matrix, i, j, max + 1)) {
                    max++;
                }
                if (max == canMax) {
                    return max * max;
                }
            }
        }
        return max * max;
    }
    public boolean isSquare(char[][] matrix, int m, int n, int length) {
        int M = matrix.length;
        int N = matrix[0].length;
        if (m + length <= M && n + length <= N) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrix[m + i][n + j] == '0') {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
