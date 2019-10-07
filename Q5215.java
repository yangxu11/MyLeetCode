package leetcode;

/**
 * 黄金矿工
 *
 * @author yx
 * @create 2019-10-06  11:10
 **/
public class Q5215 {
    int res = 0;
    int xlen;
    int ylen;

    public static void main(String[] args) {
        Q5215 q = new Q5215();
        int[][] g = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(q.getMaximumGold(g));
    }
    public int getMaximumGold(int[][] grid) {
        int xlen = grid.length;
        int ylen = grid[0].length;

        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(grid[i][j]>0){
                    dfs(grid,i,j,0,new boolean[xlen][ylen]);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid,int i,int j,int sum,boolean[][] visited){
        if(i<0 || i>=xlen || j<0 || j>=ylen || visited[i][j] || grid[i][j]==0){
            res = Math.max(sum,res);
            return;
        }
        visited[i][j] = true;
        sum += grid[i][j];
        dfs(grid,i+1,j,sum,visited);
        dfs(grid,i-1,j,sum,visited);
        dfs(grid,i,j-1,sum,visited);
        dfs(grid,i,j+1,sum,visited);
        visited[i][j] = false;
    }
}
