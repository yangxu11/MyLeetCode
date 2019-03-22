package leetcode;

import java.util.LinkedList;
//有效的括号
public class Q20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0 ; i<s.length() ; i++){
            switch(s.charAt(i)){
                case '(' : stack.push(')');break;
                case '[' : stack.push(']');break;
                case '{' : stack.push('}');break;
                case ')' : if(stack.isEmpty() || stack.pop()!=')') return false;break;
                case ']' : if(stack.isEmpty() || stack.pop()!=']') return false;break;
                case '}' : if(stack.isEmpty() || stack.pop()!='}') return false;break;
            }
        }
        return stack.isEmpty();
    }
}
