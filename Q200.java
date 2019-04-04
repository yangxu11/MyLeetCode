package leetcode;
//岛屿的个数
public class Q200 {
    int xlen,ylen;
    //深度优先搜索，
    // 遍历数组，先找到一个'1'将它和与它相连的1全部赋值为0，count++
    public int numIslands(char[][] grid) {
        xlen = grid.length;
        if(xlen==0) return 0;
        ylen = grid[0].length;
        if(ylen==0) return 0;
        int count =0;
        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int x,int y){
        if(x<0||x>=xlen||y<0||y>=ylen||grid[x][y]=='0') return;
        grid[x][y]='0';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}
