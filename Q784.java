package leetcode;

import java.util.ArrayList;
import java.util.List;
//字母大小写全排列
public class Q784 {
    //执行用时 : 9 ms, 在Letter Case Permutation的Java提交中击败了86.15% 的用户
    //内存消耗 : 42.2 MB, 在Letter Case Permutation的Java提交中击败了7.23% 的用户

    //递归 回溯
    //将数字直接加入str中，遇到字母分大小写
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(S,0,new String());
        return res;
    }
    public void dfs(String s,int index,String str){
        while(index<s.length() && s.charAt(index)>='0' && s.charAt(index)<='9'){
            str+= s.charAt(index);
            index++;
        }
        if(index == s.length()){
            res.add(str);
            return;
        }
        dfs(s,index+1,str+Character.toLowerCase(s.charAt(index)));//小写递归
        dfs(s,index+1,str+Character.toUpperCase(s.charAt(index)));//大写递归

    }
}
