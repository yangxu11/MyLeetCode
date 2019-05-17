package leetcode;

import java.util.ArrayList;
import java.util.List;
//太平洋大西洋水流问题，与被包围的区域相同解法，
// 从边缘出发，先将能到达边缘的位置标记起来，剩下的就是到不了或者被包围的

//此题需要两个数组来分别记录太平洋和大西洋，都有标记的为解
public class Q417 {
    int row,col;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int xlen = matrix.length;
        if(xlen == 0) return res;
        int ylen = matrix[0].length;
        if(ylen==0) return res;
        row=xlen;
        col=ylen;
        boolean[][] m1 = new boolean[xlen][ylen];
        boolean[][] m2 = new boolean[xlen][ylen];

        for(int i=0 ; i<ylen ; i++){
            dfs(matrix,0,i,m1);
            dfs(matrix,xlen-1,i,m2);
        }
        for(int i=0 ; i<xlen ; i++){
            dfs(matrix,i,0,m1);
            dfs(matrix,i,ylen-1,m2);
        }
        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(m1[i][j]&&m2[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix,int x,int y,boolean[][] m){
        if(x<0||x>=row||y<0||y>=col||m[x][y]) return;
        m[x][y] = true;

        for(int[] dir : dirs){
            int i = x+dir[0];
            int j = y+dir[1];

            if(i>=0&&i<row&&j>=0&&j<col&&matrix[i][j]>=matrix[x][y]){
                dfs(matrix,i,j,m);
            }
        }

    }
}
