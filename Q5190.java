package leetcode;

import java.util.Stack;

/**
 * 反转每个括号见的字符串
 *
 * @author yx
 * @create 2019-09-15  10:56
 **/
public class Q5190 {
    public static void main(String[] args) {
        Q5190 q  =new Q5190();
        String s = "((ab)(cd))";
        System.out.println(q.reverseParentheses(s));
    }
    int r = 0;
    public String reverseParentheses(String s) {

        if(r==1){
            s = reverse(s);
        }

        int index = s.indexOf("(");
        if(index==-1) return s;
        r=1;
        String res = "";
        index = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            } else if(s.charAt(i)==')'){
                if(stack.size()==1){
                    int num = stack.pop();
                    res += s.substring(index,num) +reverseParentheses(s.substring(num+1,i));
                    index = i+1;
                } else{
                    stack.pop();
                }
            }
        }

        return res;
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1 ; i>=0 ; i--){
            if(s.charAt(i)=='('){
                sb.append(")");
            } else if(s.charAt(i)==')'){
                sb.append("(");
            } else{
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}
