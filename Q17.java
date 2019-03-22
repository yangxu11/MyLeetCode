package leetcode;

import java.util.ArrayList;
import java.util.List;
//电话号码的字母组合
public class Q17 {

    //经典回溯
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations1(String digits) {
        if(digits.length() == 0) return res;
        String[] strs = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(strs,digits,new String(),0);
        return res;
    }

    public void dfs(String[] strs,String digits,String str,int num){
        if(num == digits.length()) {
            res.add(str);
            return;
        }
        String letters = strs[digits.charAt(num)-'2'];
        for(int i=0 ; i<letters.length() ; i++){
            str += letters.charAt(i);
            dfs(strs,digits,str,num+1);
            str = str.substring(0,str.length()-1);
        }
    }


    //执行用时: 4 ms, 在Letter Combinations of a Phone Number的Java提交中击败了50.89% 的用户
    //内存消耗: 27.2 MB, 在Letter Combinations of a Phone Number的Java提交中击败了21.48% 的用户

    //使用一个list存储当前所有的字符串，新来一个数字时，在当前list后面加上这个数字可能对应的字母，更新list
    public List<String> letterCombinations(String digits) {
        String[] strs = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return dfs(strs,digits,new ArrayList<>(),0);
    }

    public List<String> dfs(String[] strs,String digits,List<String> result,int num){
        if(num == digits.length()) return result;
        char c = digits.charAt(num);
        String str = strs[c-'2'];
        List<String> list = new ArrayList<>();
        for(int i=0 ; i<str.length() ; i++){
            if(result.size() == 0){
                list.add(String.valueOf(str.charAt(i)));
            } else {
                for(String s : result){
                    list.add(s+str.charAt(i));
                }
            }

        }
        return dfs(strs,digits,list,num+1);
    }
}
