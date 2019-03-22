package leetcode;
//单词搜索
public class Q79 {
    //执行用时: 15 ms, 在Word Search的Java提交中击败了79.29% 的用户
    //内存消耗: 39.4 MB, 在Word Search的Java提交中击败了23.73% 的用户

    //深度优先搜索，递归
    //注意搜索时不能回头，加一个visited数组记录遍历过的点，搜索完后要将visited值还原
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        boolean res = false;
        boolean[][] visited =new boolean[board.length][board[0].length];
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j]==c && dfs(board,word,0,i,j,visited)){
                    return true;
                }
            }
        }
        return res;
    }
    public boolean dfs(char[][] board,String word,int index,int x,int y,boolean[][] visited){
        if(index == word.length()) return true;
        if(x<0 || x>=board.length || y<0 || y>=board[0].length
                || word.charAt(index)!=board[x][y]||visited[x][y])
            return false;
        visited[x][y]=true;//标记
        boolean b = false;
        for(int[] dir :dirs){//四个方向
            b = b||dfs(board,word,index+1,x+dir[0],y+dir[1],visited);
        }
        visited[x][y] =false;//还原
        return b;
    }
}
