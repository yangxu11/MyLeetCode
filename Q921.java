package leetcode;

import java.util.LinkedList;
//使括号有效的最少添加
public class Q921 {
    //使用栈，匹配弹出，不匹配入栈
    public int minAddToMakeValid(String S) {
        if(S.length() ==0) return 0;

        LinkedList<Character> stack = new LinkedList<>();

        for(int i=0 ; i<S.length() ; i++){
            if(S.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }

        }
        return stack.size();
    }
}
