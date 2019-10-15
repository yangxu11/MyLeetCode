package leetcode;

import java.util.Stack;

/**
 * 最长的括号
 *
 * @author yx
 * @create 2019-10-15  17:14
 **/
public class Q32 {
    public static void main(String[] args) {
        Q32 q = new Q32();
        String s = ")(())(()()))(";
        System.out.println(q.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);

        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
}
