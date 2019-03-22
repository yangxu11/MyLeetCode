package leetcode;

import java.util.ArrayList;
import java.util.List;
//太平洋大西洋水流问题，与被包围的区域相同解法，
// 从边缘出发，先将能到达边缘的位置标记起来，剩下的就是到不了或者被包围的

//此题需要两个数组来分别记录太平洋和大西洋，都有标记的为解
public class Q417 {
    int xlen,ylen;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix.length==0) return result;

        xlen = matrix.length;
        ylen = matrix[0].length;

        int[][] m = new int[xlen][ylen];
        int[][] n = new int[xlen][ylen];

        for(int i=0 ; i<xlen ; i++) {
            dfs(matrix,i,0,m);
            dfs(matrix,i,ylen-1,n);
        }
        for(int i=0 ; i<ylen ; i++) {
            dfs(matrix,0,i,m);
            dfs(matrix,xlen-1,i,n);
        }

        for(int i=0 ; i<xlen ; i++) {
            for(int j=0 ; j<ylen ; j++) {
                if(m[i][j]==1 && n[i][j]==1) {
                    int[] sub = new int[2];
                    sub[0]=i;
                    sub[1]=j;
                    result.add(sub);
                }
            }
        }

        return result;

    }

    public void dfs(int[][] matrix,int x,int y,int[][] m) {
        if(x<0||x>=xlen||y<0||y>=ylen||m[x][y]!=0) return;
        if(m[x][y]==0) {
            m[x][y] = 1;
        }
        if((x-1>=0)&&(matrix[x-1][y]>=matrix[x][y])){
            dfs(matrix,x-1,y,m);
        }
        if((x+1<xlen)&&(matrix[x+1][y]>=matrix[x][y])){
            dfs(matrix,x+1,y,m);
        }
        if((y-1>=0)&&(matrix[x][y-1]>=matrix[x][y])){
            dfs(matrix,x,y-1,m);
        }
        if((y+1<ylen)&&(matrix[x][y+1]>=matrix[x][y])){
            dfs(matrix,x,y+1,m);
        }
    }
}
