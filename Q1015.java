package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1015 {
    public static void main(String[] args) {
        Q1015 q = new Q1015();
        System.out.println(q.numDupDigitsAtMostN(20));
    }
    int second = 0;
    public int numDupDigitsAtMostN(int N) {
        int ans =0;
        if(N<=10) return 0;
        int w = getWei(N);
        int[] dp = new int[w];
        dp[0] = 1;
        dp[1] = 9;
        int res = 9;
        for(int i=2 ; i<w ; i++){
            dp[i] = (10-i+1)*dp[i-1];
            res += dp[i];
        }
        long x=1;
        while(x<N){
            x *= 10;
        }
        x = x/10;
        int first = (int)(x-1) - res;

        String s = String.valueOf(N);

        List<Character> list = new ArrayList<>();
        for(int i=1 ; i<=Integer.parseInt(String.valueOf(s.charAt(0)));i++){
            list.add((char)(i+'0'));
            dfs(s,1,list);
            list.remove(list.size()-1);
        }

        return N-(int)x+1-second+first;


    }

    public void dfs(String s, int num , List<Character> list){
        if(num == s.length()) {
            second++;
            return;
        }
        for(int i=0 ; i<=Integer.parseInt(String.valueOf(s.charAt(num))) ; i++){
            if(!list.contains((char)(i+'0'))){
                list.add((char)(i+'0'));
                dfs(s,num+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public int getWei(int n){
        int res = 0;
        while(n>0){
            res++;
            n /= 10;
        }
        return res;
    }
}
