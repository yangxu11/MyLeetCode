package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除无效的括号
 *
 * @author yx
 * @create 2019-11-07  20:04
 **/
public class Q301 {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;

        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c=='('){
                left++;
            } else if(c==')'){
                if(left>0){
                    --left;
                } else{
                    ++right;
                }
            }
        }

        dfs(new StringBuilder(s),left,right,0);
        return res;
    }

    public void dfs(StringBuilder sb,int left,int right,int index){
        if(left==0 && right==0 && isValid(sb)){
            res.add(sb.toString());
            return;
        }

        for(int i=index ; i<sb.length() ; i++){
            char c = sb.charAt(i);
            //StringBuilder tmp = new StringBuilder(sb);
            sb.deleteCharAt(i);
            if(c=='(' && left>0){
                dfs(sb,left-1,right,i);
            }
            if(c==')' && right>0){
                dfs(sb,left,right-1,i);
            }
            sb.insert(i,c);
        }
    }

    public boolean isValid(StringBuilder sb){
        int left = 0;
        for(int i=0 ; i<sb.length() ; i++){
            char c = sb.charAt(i);
            if(c=='('){
                ++left;
            } else if(c==')'){
                if(left<=0){
                    return false;
                }
                --left;
            }
        }
        return left==0;
    }
}
