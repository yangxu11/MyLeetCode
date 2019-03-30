package leetcode;

/**
 * 被包围的区域
 *
 * @author yx
 * @create 2019-03-30  11:06
 **/
public class Q130 {
    //从边界向内部bfs，如果最后没有遍历到，说明被包围，置为'X'
    int xlen,ylen;
    public void solve(char[][] board) {
        xlen = board.length;
        if(xlen==0) return;
        ylen = board[0].length;
        if(ylen==0) return;
        int[][] visited = new int[xlen][ylen];
        for(int i=0 ; i<xlen ; i++){
            bfs(board,i,0,visited);
        }
        for(int i=0 ; i<ylen ; i++){
            bfs(board,0,i,visited);
        }
        for(int i=0 ; i<xlen ; i++){
            bfs(board,i,ylen-1,visited);
        }
        for(int i=0 ; i<ylen ; i++){
            bfs(board,xlen-1,i,visited);
        }
        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(board[i][j]=='O'&&visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }
    public void bfs(char[][] board,int x,int y,int[][] visited){
        if(x<0||x>=xlen||y<0||y>=ylen||visited[x][y]==1||board[x][y]=='X') return;
        visited[x][y]=1;
        bfs(board,x-1,y,visited);
        bfs(board,x+1,y,visited);
        bfs(board,x,y-1,visited);
        bfs(board,x,y+1,visited);
    }
}
