package leetcode;

import java.util.ArrayList;
import java.util.List;
//分割回文串
public class Q131 {
    //执行用时: 7 ms, 在Palindrome Partitioning的Java提交中击败了88.13% 的用户
    //内存消耗: 40.5 MB, 在Palindrome Partitioning的Java提交中击败了26.00% 的用户

    //递归 + 判断回文子串
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }
    public void dfs(String s,int index,List<String> list){
        if(index >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index ; i<s.length() ; i++){
            if(isBackToText(s.substring(index,i+1))){
                list.add(s.substring(index,i+1));
                dfs(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isBackToText(String s){//判断回文子串
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
