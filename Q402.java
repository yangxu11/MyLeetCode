package leetcode;

import java.util.Stack;

/**
 * 移掉K位数字
 *
 * @author yx
 * @create 2019-05-15  21:46
 **/
public class Q402 {
    //栈
    //栈顶保留最大元素，如果新来的数小于栈顶，栈顶弹出
    public String removeKdigits(String num, int k) {
        if(num.length()<=k || num.length()==0)
            return "0";

        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));

        for(int i=1 ; i<num.length() ; i++){
            char c = num.charAt(i);
            while(!stack.isEmpty() && k>0 && c<stack.peek()){
                stack.pop();
                --k;
            }
            if(c!='0' || !stack.isEmpty()){
                stack.push(c);
            }
        }
        while(k>0){
            stack.pop();
            --k;
        }
        if(stack.isEmpty()) return "0";
        StringBuilder sb  = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
