package leetcode;

import java.util.Arrays;
//令牌放置
public class Q948 {
    //先升序排序，将所有点数与小点数的令牌兑换成分数，然后将一个分数与最大点数的令牌兑换成点数
    //然后循环，直到end==start
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int count=0;
        int point = P;
        int start=0;
        int end= tokens.length-1;
        while(start<=end){
            while(start<=end){
                if(point>=tokens[start]){
                    count++;
                    point -= tokens[start];
                    start++;
                } else {
                    break;
                }
            }
            if(end > start && count>=1){
                point += tokens[end];
                end--;
                count--;
            } else {
                return count;
            }

        }
        return count;
    }
}
