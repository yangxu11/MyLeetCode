package leetcode;
//二维区域和检索 - 矩阵不可变
public class Q304 {
    //执行用时: 126 ms, 在Range Sum Query 2D - Immutable的Java提交中击败了67.86% 的用户
    //内存消耗: 39 MB, 在Range Sum Query 2D - Immutable的Java提交中击败了70.37% 的用户

    //使用动态规划
    //先建立一个数组dp[][] 存储(0,0)到(i,j)的矩阵的和，使用动态规划
    // dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];

    //则所求范围的和= dp[row1-1][col1-1]+dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1]  注意row1,col1=0 的时候
    class NumMatrix2 {
        int[][] matrix;
        int[][] dp;
        public NumMatrix2(int[][] matrix) {
            this.matrix = matrix;
            if(matrix.length==0) return;
            dp = new int[matrix.length][matrix[0].length];
            dp[0][0] = matrix[0][0];

            for(int i=1 ; i<matrix.length ; i++){
                dp[i][0] = dp[i-1][0] + matrix[i][0];
            }
            for(int i=1 ; i<matrix[0].length ; i++){
                dp[0][i] = dp[0][i-1] + matrix[0][i];
            }
            for(int i=1 ; i<matrix.length ; i++){
                for(int j=1 ; j<matrix[0].length ; j++){
                    dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(matrix.length==0) return 0;

            if(row1==0 && col1==0){
                return dp[row2][col2];
            } else if(row1==0 && col1>0){
                return dp[row2][col2] - dp[row2][col1-1];
            } else if(row1>0 && col1==0){
                return dp[row2][col2] - dp[row1-1][col2];
            }
            return dp[row1-1][col1-1]+dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1];
        }
    }
    //执行用时: 373 ms, 在Range Sum Query 2D - Immutable的Java提交中击败了3.06% 的用户
    //内存消耗: 52.7 MB, 在Range Sum Query 2D - Immutable的Java提交中击败了0.00% 的用户

    //暴力法，不使用动态规划，重复加和
    class NumMatrix {
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int i=row1 ; i<= row2 ; i++){
                for(int j=col1 ; j<=col2 ; j++){
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }

}
