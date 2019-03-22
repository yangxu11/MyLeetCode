package leetcode;
//不同的路径II
public class Q63 {
    //1ms 94%
    //同62，注意最上面和最左面在遇到1之后要break
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xlen = obstacleGrid.length;
        int ylen = obstacleGrid[0].length;
        int[][] dp = new int[xlen][ylen];

        for(int i=0 ; i<xlen ; i++){
            if(obstacleGrid[i][0]==1) break;
            dp[i][0] = 1;
        }
        for(int i=0 ; i<ylen ; i++){
            if(obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for(int i=1 ; i<xlen ; i++){
            for(int j=1 ; j<ylen ; j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[xlen-1][ylen-1];
    }
}
