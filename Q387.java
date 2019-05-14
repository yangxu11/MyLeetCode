package leetcode;

import java.util.Arrays;

/**
 * 字符串中的第一个唯一字符
 *
 * @author yx
 * @create 2019-05-14  17:04
 **/
public class Q387 {
    //使用数组存储第一次出现时的下标，如果再次出现，赋值为-2
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;

        int[] visited = new int[26];
        Arrays.fill(visited,-1);
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            int index = c-'a';
            if(visited[index]==-2){
                continue;
            } else if(visited[index]>=0){
                visited[index] = -2;
            } else{
                visited[index] = i;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0 ; i<26 ; i++){
            if(visited[i]>=0){
                res = Math.min(res,visited[i]);
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}
