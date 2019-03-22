package leetcode;
//最小路径和
public class Q64 {
    //8ms 67%
    //基础动态规划题，思路同62，63
    //累积计算前面所有点的最小路径，注意先算出边缘的路径和（最上和最左）
    public int minPathSum(int[][] grid) {
        int xlen = grid.length;
        int ylen = grid[0].length;

        for(int i=1 ; i<xlen ; i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int i=1 ; i<ylen ; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i=1 ; i<xlen ; i++){
            for(int j=1 ; j<ylen ; j++){
                grid[i][j] = Math.min(grid[i][j]+grid[i-1][j],grid[i][j]+grid[i][j-1]);
            }
        }

        return grid[xlen-1][ylen-1];
    }
}
