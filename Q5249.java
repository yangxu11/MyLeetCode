package leetcode;

import java.util.Stack;

/**
 * 移除无效括号
 *
 * @author yx
 * @create 2019-11-03  11:18
 **/
public class Q5249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexs = new Stack<>();
        int left = 0;

        int len = s.length();

        for(int i=0 ; i<len ; i++){
            char c  = s.charAt(i);
            if(c=='('){
                ++left;
                stack.push('(');
            } else if(c == ')'){
                if(left>0){
                    --left;
                    stack.push(')');
                }
            } else{
                stack.push(c);
            }
        }
        int right = 0;
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c==')'){
                right++;
                sb.append(c);
            } else if(c=='('){
                if(right>0){
                    sb.append(c);
                    --right;
                }
            } else{
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}
