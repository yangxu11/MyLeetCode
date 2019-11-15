package leetcode;

/**
 * 得分最高的单词集合
 *
 * @author yx
 * @create 2019-11-10  11:16
 **/
public class Q5258 {
    int res = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] t = new int[26];
        for(char c : letters){
            t[c-'a'] += 1;
        }
        int len = words.length;
        int[][] nums = new int[len][26];
        for(int i=0 ; i<len ; i++){
            nums[i] = getNum(words[i]);
        }
        dfs(nums,0,new int[26],t,score);
        return res;
    }

    public void dfs(int[][] nums,int index,int[] cur,int[] t,int[] score){
        if(index==nums.length){
            return;
        }

        for(int i=index ; i<nums.length ; i++){
            cur = merge(nums[i],cur);
            if(isValid(cur,t)){
                res = Math.max(res,getScore(cur,score));
                dfs(nums,i+1,cur,t,score);
            }
            cur = del(nums[i],cur);
        }
    }
    public int[] merge(int[] num,int[] cur){
        for(int i=0 ; i<26 ; i++){
            cur[i] += num[i];
        }
        return cur;
    }
    public int[] del(int[] num,int[] cur){
        for(int i=0 ; i<26 ; i++){
            cur[i] -= num[i];
        }
        return cur;
    }
    public boolean isValid(int[] cur,int[] t){
        for(int i=0 ; i<26 ; i++){
            if(cur[i]>t[i]){
                return false;
            }
        }
        return true;
    }
    public int getScore(int[] cur,int[] score){
        int res = 0;
        for(int i=0 ; i<26 ; i++){
            res += cur[i]*score[i];
        }
        return res;
    }
    public int[] getNum(String s){
        int[] res = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            res[s.charAt(i)-'a'] += 1;
        }
        return res;
    }
}
