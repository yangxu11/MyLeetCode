package leetcode;

/**
 * 通配符匹配
 *
 * @author yx
 * @create 2019-10-17  21:12
 **/
public class Q44 {
    public static void main(String[] args) {
        Q44 q = new Q44();
        String s = "adceb";
        String p = "*a*b";
        System.out.println(q.isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;

        for(int i=1 ; i<=pLen ; i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = true;
            } else{
                break;
            }
        }

        for(int i=1 ; i<=sLen ; i++){
            for(int j=1 ; j<=pLen ; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)=='*'){
                    for(int k=i ; k>=0 ; k--){
                        if(dp[k][j-1]){
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }
}
