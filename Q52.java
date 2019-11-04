package leetcode;

/**
 * N皇后II
 *
 * @author yx
 * @create 2019-10-21  20:06
 **/
public class Q52 {
    public static void main(String[] args) {
        Q52 q = new Q52();
        System.out.println(q.totalNQueens(2));
    }
    int res = 0;
    public int totalNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        dfs(grid,0);
        return res;
    }

    public void dfs(boolean[][] grid,int row){
        if(row == grid.length){
            ++res;
            return;
        }

        for(int i=0 ; i<grid.length ; i++){
            if(isValid(grid,row,i)){
                grid[row][i] = true;
                dfs(grid,row+1);
                grid[row][i] = false;
            }
        }
    }

    public boolean isValid(boolean[][] grid,int x,int y){
        int n = grid.length;

        for(int i=0 ; i<n ; i++){
            if(grid[x][i] || grid[i][y]){
                return false;
            }
        }
        int i = x;
        int j = y;

        while(i>=0 && j>=0){
            if(grid[i][j]){
                return false;
            }
            i--;
            j--;
        }
        i=x;
        j=y;
        while(i<n && j<n){
            if(grid[i][j]){
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
