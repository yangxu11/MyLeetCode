package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//基本计算器II
public class Q227 {
    //逆波兰表达式求法
    public static void main(String[] args) {
        Q227 q = new Q227();
        String s = "12 + 2 * 3 + 4";
        System.out.println(q.calculate(s));
    }
    //10%
    public int calculate(String s) {
        String postfix = getPostfix(s);
        return getResult(postfix);
    }
    //得到逆波兰表达式
    //出现数字直接加到表达式中，注意多位数
    //出现符号，观察栈顶元素优先级，如果小于等于当前元素的优先级，出栈，加入到表达式中，循环，然后将当前符号进栈
    //如果出现')'，将所有第一个'('出现前的符号出栈，加入到表达式中
    //最后将所有符号出栈
    public String getPostfix(String s){
        Map<Character,Integer> priority = new HashMap<>();
        priority.put('+',0);
        priority.put('-',0);
        priority.put('*',1);
        priority.put('/',1);
        priority.put('(',2);
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0 ; i<s.length() ;){
            char c = s.charAt(i);
            if(c>='0' && c<='9') {
                String num = "";
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num += s.charAt(i);
                    i++;
                }
                sb.append(" " + num);
            } else {
                if(c=='('){
                    stack.push(c);
                }
                if(c==')'){
                    while(stack.peek()!='('){
                        sb.append(" " + stack.pop());
                    }
                    stack.pop();
                }
                if(c=='/' || c=='*' || c=='+' || c=='-'){
                    while(!stack.isEmpty() && stack.peek()!='(' &&(priority.get(stack.peek()) >= priority.get(c)) ){
                        sb.append(" " + stack.pop());
                    }
                    stack.push(c);
                }
                i++;
            }
        }
        while(!stack.isEmpty()){
            sb.append(" " + stack.pop());
        }
        return sb.toString().trim();
    }
    //根据逆波兰表达式得到结果，如果是数字，进栈，如果是符号，出栈两个数字运算后再进栈
    public int getResult(String postfix){
        LinkedList<Integer> stack = new LinkedList<>();
        String[] strs = postfix.split(" ");

        for(int i=0 ; i<strs.length ; i++){
            String s = strs[i];
            if(s.charAt(0)>='0' && s.charAt(0)<='9'){
                stack.push(Integer.parseInt(s));
                continue;
            }
            char c= s.charAt(0);
            int x = stack.pop();
            int y = stack.pop();
            if(c=='*'){
                stack.push(y*x);
            }
            if(c=='/'){
                stack.push(y/x);
            }
            if(c=='+'){
                stack.push(y+x);
            }
            if(c=='-'){
                stack.push(y-x);
            }
        }
        return stack.peek();
    }
}
