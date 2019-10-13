package leetcode;

/**
 * 掷骰子模拟
 *
 * @author yx
 * @create 2019-10-13  11:20
 **/
public class Q5224 {
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp = new long[n+1][6][16];
        int mod = 1000000007;

        for(int i=0 ; i<6 ; i++){
            dp[1][i][1] = 1;
        }

        for(int i=2 ; i<=n ; i++){
            for(int j=0 ; j<6 ; j++){
                for(int k=0 ; k<6 ; k++){
                    if(k==j){
                        for(int m=1 ; m<=rollMax[j] ; m++){
                            dp[i][j][m] += dp[i-1][k][m-1];
                            dp[i][j][m] %= mod;
                        }
                    } else{
                        for(int m=1 ; m<=rollMax[k] ; m++){
                            dp[i][j][1] += dp[i-1][k][m];
                            dp[i][j][1] %= mod;
                        }
                    }
                }
            }
        }
        long res = 0;
        for(int i=0 ; i<6 ; i++){
            for(int j=0 ; j<=rollMax[i] ; j++){
                res += dp[n][i][j];
                res %= mod;
            }
        }
        return (int)res;
    }
}
