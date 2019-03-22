package leetcode;
//最大的岛屿面积，与（树的最大深度）相似
public class Q695 {
    int xlen,ylen;
    public int maxAreaOfIsland(int[][] grid) {
        xlen = grid.length;
        ylen = grid[0].length;
        if(xlen==0) return 0;
        int result=0;
        for(int i=0 ; i<xlen ; i++) {
            for(int j=0 ; j<ylen ; j++) {
                if(grid[i][j]==1) {
                    result = Math.max(result,dfs(grid,i,j));
                }
            }
        }

        return result;
    }

    public int dfs(int[][] grid,int x,int y) {
        if(x<0||x>=xlen||y<0||y>=ylen||grid[x][y]!=1) return 0;

        grid[x][y]=0;
        return 1+dfs(grid,x-1,y)+dfs(grid,x+1,y)+
                dfs(grid,x,y-1)+dfs(grid,x,y+1);
    }
}
