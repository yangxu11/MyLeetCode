package leetcode;

/**
 * 解数独
 *
 * @author yx
 * @create 2019-10-15  21:04
 **/
public class Q37 {
    public void solveSudoku(char[][] board) {
        dfs(board,0,0);
    }

    public boolean dfs(char[][] board,int x,int y){
        int nextx=-1,nexty=-1;
        if(x==8){
            if(y==8){
                nextx = -1;
                nexty=-1;
            } else{
                nextx = 0;
                nexty = y+1;
            }
        } else{
            nextx = x+1;
            nexty = y;
        }

        if(board[x][y]=='.'){
            for(int num=1 ; num<=9 ; num++){
                boolean flag = false;
                char c = (char)(num+'0');
                for(int i=0 ; i<9 ; i++){
                    if(board[x][i]==c || board[i][y]==c){
                        flag = true;
                    }
                }
                int x1 = x/3;
                int y1 = y/3;
                for(int i=x1*3 ; i<x1*3+3 ; i++){
                    for(int j=y1*3 ; j<y1*3+3 ; j++){
                        if(board[i][j]==c){
                            flag = true;
                        }
                    }
                }
                if(flag) continue;
                board[x][y] = c;
                if(nextx==-1){
                    return true;
                } else{
                    if(dfs(board,nextx,nexty)){
                        return true;
                    } else{
                        board[x][y] = '.';
                    }
                }
            }
        } else{
            if(nextx==-1){
                return true;
            }
            return dfs(board,nextx,nexty);
        }
        return false;
    }
}
