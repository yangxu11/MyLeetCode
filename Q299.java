package leetcode;

/**
 * 猜数字游戏
 *
 * @author yx
 * @create 2019-04-18  17:25
 **/
public class Q299 {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] s = new int[26];
        int[] g = new int[26];

        for(int i=0 ; i<secret.length() ; i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2){
                ++bull;
            } else{
                if(g[c1-'0']>0){
                    ++cow;
                    g[c1-'0'] -= 1;
                }else{
                    s[c1-'0'] += 1;
                }

                if(s[c2-'0']>0){
                    ++cow;
                    s[c2-'0'] -= 1;
                } else{
                    g[c2-'0'] += 1;
                }
            }
        }

        return bull+"A"+cow+"B";
    }
}
