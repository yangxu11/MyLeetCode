package leetcode;
//不同的路径II
public class Q63 {
    //1ms 94%
    //同62，可以将累积值设为负数，防止和1（obstacle）冲突，最后取相反数
    //注意最上面和最左面边界赋值时，出现一个1就需要break了，剩下的全为0
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xlen = obstacleGrid.length;
        int ylen = obstacleGrid[0].length;
        for(int i=0 ; i<xlen ; i++){
            if(obstacleGrid[i][0]==1){
                break;
            } else {
                obstacleGrid[i][0]=-1;
            }
        }
        for(int i=0 ; i<ylen ; i++){
            if(obstacleGrid[0][i]==1){
                break;
            } else {
                obstacleGrid[0][i]=-1;
            }
        }

        for(int i=1 ; i<xlen ; i++){
            for(int j=1 ; j<ylen ; j++){
                if(obstacleGrid[i][j]==1) {
                    obstacleGrid[i][j]=0;
                    continue;
                }
                if(obstacleGrid[i-1][j]==1 && obstacleGrid[i][j-1] ==1 ){
                    obstacleGrid[i][j] = 0;
                }else if(obstacleGrid[i-1][j]==1) {
                    obstacleGrid[i][j] = 0 + obstacleGrid[i][j-1];
                }else if(obstacleGrid[i][j-1] ==1 ){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[xlen-1][ylen-1]==1 ? 0 : -obstacleGrid[xlen-1][ylen-1];
    }
}
