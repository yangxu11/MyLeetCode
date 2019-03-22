package leetcode;

public class Q688 {
    //执行用时: 19 ms, 在Knight Probability in Chessboard的Java提交中击败了53.85% 的用户
    //内存消耗: 34.1 MB, 在Knight Probability in Chessboard的Java提交中击败了12.50% 的用户

    //使用dp[][]存储上一次嘛落在各个点的概率
    //则第K次时，遍历dp[][]，每个落在棋盘点上的概率 += dp[i][j]*0.125，得到所有点的概率
    //最后加和得到结果
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        double res = 0;
        int[][] move ={{1,2},{2,1},{2,-1},{1,-2},{-1,2},{-2,1},{-1,-2},{-2,-1}};

        while(K>0){
            double[][] dp1 = new double[N][N];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    for(int[] m : move){
                        int x = i + m[0];
                        int y = j + m[1];
                        if(!(x<0 || x>=N || y<0 || y>=N )){
                            dp1[x][y] += dp[i][j] * 0.125;
                        }
                    }
                }
            }
            dp = dp1;
            K--;
        }
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                res += dp[i][j];
            }
        }

        return res;
    }
}
