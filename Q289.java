package leetcode;
//生命游戏
public class Q289 {
    public void gameOfLife1(int[][] board) {
        //2ms 99% 不使用额外空间   计算周围的存活个数，写法很棒！！！！
        /**
         利用一个 two bits 的状态机来记录细胞状态, 第一位表示
         下一状态, 第二位表示当前状态:
         00: dead (next state) <- dead (current state)
         01: dead (next state) <- live (current state)
         10: live (next state) <- dead (current state)
         11: live (next state) <- live (current state)
         初始情况对应就是 00 和 01 (默认下一状态是 dead state)
         统计每个位置周围的 live 细胞数决定高位置 1 (live)还是
         0 (dead), 最后右移一位即为最终状态, 注意不需要考虑 01
         以及 00 的情况, 因为已经默认下一状态为 dead.
         **/
        if(board.length < 1) return;
        // 更新矩阵
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                int lives = countLives(board, i, j);
                // live -> live
                if((board[i][j] & 1) == 1) {
                    if(lives >= 2 && lives <= 3)
                        board[i][j] = 3;
                }
                // dead -> live
                else {
                    if(lives == 3)
                        board[i][j] = 2;
                }
            }
        }
        // 重置矩阵
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j)
                board[i][j] >>= 1;
        }
    }
    //计算周围的存活个数，写法很棒！！！！
    private int countLives(int[][] b, int i, int j) {
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x > b.length-1 || y < 0 || y > b[0].length-1)
                continue;
            count += (b[x][y] & 1);
        }
        return count;
    }
    //2ms 99%  但是使用了额外空间O(mn)
    //新建一个数组存储周围活细胞的个数，然后再循环判断生死
    public void gameOfLife2(int[][] board) {
        int xlen = board.length;
        int ylen = board[0].length;

        int[][] nums = new int[xlen][ylen];

        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                nums[i][j] = getLive(board,i,j);
            }
        }

        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                if(nums[i][j] < 2 || nums[i][j]>3) board[i][j]=0;
                if(nums[i][j]==3) board[i][j]=1;
            }
        }

    }
    public int getLive(int[][] board,int x,int y){
        int xlen = board.length;
        int ylen = board[0].length;
        int count = 0;
        if(x-1>=0 && y-1>=0){
            if(board[x-1][y-1]==1) count++;
        }
        if(x-1>=0 && y>=0){
            if(board[x-1][y]==1) count++;
        }
        if(x-1>=0 && y+1<=ylen-1){
            if(board[x-1][y+1]==1) count++;
        }
        if(x>=0 && y-1>=0){
            if(board[x][y-1]==1) count++;
        }
        if(x>=0 && y+1<=ylen-1){
            if(board[x][y+1]==1) count++;
        }
        if(x+1<=xlen-1 && y-1>=0){
            if(board[x+1][y-1]==1) count++;
        }
        if(x+1<=xlen-1 && y>=0){
            if(board[x+1][y]==1) count++;
        }
        if(x+1<=xlen-1 && y+1<=ylen-1){
            if(board[x+1][y+1]==1) count++;
        }
        return count;
    }
}
