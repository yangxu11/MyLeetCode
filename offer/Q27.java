package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排序
 *
 * @author yx
 * @create 2019-05-05  16:38
 **/
public class Q27 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0) return res;
        char[] letters = str.toCharArray();
        Arrays.sort(letters);
        dfs(letters,new String(),new int[str.length()]);
        return res;
    }
    public void dfs(char[] letters,String str,int[] visited){
        if(str.length() == letters.length){
            res.add(str);
            return;
        }
        for(int i=0 ; i<letters.length ; i++){
            if(visited[i]==0){
                visited[i] = 1;
                dfs(letters,str+letters[i],visited);
                visited[i] = 0;
                while(i<letters.length-1 && letters[i] == letters[i+1]){
                    ++i;
                }
            }
        }
    }
}
