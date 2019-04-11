package leetcode.homework;
//扫雷
public class Q529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y]==('M')) {
            board[x][y] = 'X';
            return board;
        }
        return update(board,x,y);
    }

    public char[][] update(char[][] board , int x , int y) {
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length-1) return board;
        if(adjacentM(board,x,y)>0) {
            board[x][y] = (char)('0'+adjacentM(board,x,y));
            return board;
        } else if(board[x][y]=='E') {
            board[x][y] = 'B';
            update(board,x-1,y-1);
            update(board,x-1,y);
            update(board,x-1,y+1);
            update(board,x,y-1);
            update(board,x,y+1);
            update(board,x+1,y-1);
            update(board,x+1,y);
            update(board,x+1,y+1);
            return board;
        } else {
            return board;
        }
        // return board;
    }

    public int adjacentM(char[][] board,int x,int y) {
        int count=0;
        int xlen = board.length;
        int ylen = board[0].length;

        int xstart=x-1;
        int xend=x+1;
        int ystart = y-1;
        int yend = y+1;
        if(x==0 ) {
            xstart=x;
        }
        if(x==xlen-1) {
            xend=x;
        }
        if(y==0) {
            ystart = y;
        }
        if(y==ylen-1) {
            yend = y;
        }
        for(int i=xstart ; i<=xend ; i++) {
            for(int j=ystart ; j<=yend ; j++) {
                if(board[i][j]=='M') {
                    count++;
                }
            }
        }
        return count;
    }
}
