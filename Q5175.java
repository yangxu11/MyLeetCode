package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建回文串检测
 *
 * @author yx
 * @create 2019-09-01  14:32
 **/
public class Q5175 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();

        int[][] dp = new int[len+1][26];
        char[] ch = s.toCharArray();

        for(int i=0 ; i<len ; i++){

            for(int j=0 ; j<26 ; j++){
                dp[i+1][j] = dp[i][j];
            }
            dp[i+1][ch[i]-'a'] +=1;
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] query : queries){
            int start = query[0];
            int end = query[1]+1;
            int num = query[2];

            if(num>=end-start){
                res.add(true);
                continue;
            }
            int x = 0;
            for(int i=0 ; i<26 ; i++){
                int tmp = dp[end][i] - dp[start][i];

                if(tmp%2 == 1){
                    x++;
                }
            }


            if((start-end)%2==1){
                if(num >= (x+1)/2){
                    res.add(true);
                } else{
                    res.add(false);
                }
            } else{
                if(num >= x/2){
                    res.add(true);
                } else{
                    res.add(false);
                }
            }

        }

        return res;
    }
}
