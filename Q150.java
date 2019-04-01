package leetcode;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * @author yx
 * @create 2019-04-01  20:18
 **/
public class Q150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(!(s.equals("+") || s.equals("-")|| s.equals("*")|| s.equals("/"))){
                stack.push(Integer.parseInt(s));
            } else{
                int y = stack.pop();
                int x = stack.pop();
                int res = 0;
                switch (s){
                    case "+" : res = x+y;break;
                    case "-" : res = x-y;break;
                    case "*" : res = x*y;break;
                    case "/" : res = x/y;break;
                    default:break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
