package leetcode;

import java.util.*;

/**
 * 给表达式加运算符
 *
 * @author yx
 * @create 2019-11-07  21:48
 **/
public class Q282 {
    public static void main(String[] args) {
        String a = "123";
        Q282 q = new Q282();
        System.out.println(q.addOperators(a,6));
    }
    Map<String, List<String>> map = new HashMap<>();
    String[] sign = {"+","-","*"};
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {

        dfs(num,"",0,target);
        return res;

    }

    public void dfs(String num,String str,int index,int target){
        if(index==num.length()){
            if(getVal(str.substring(0,str.length()-1))==target){
                res.add(str);
            }
        }

        for(int i=index+1 ; i<num.length() ; i++){
            for(String si : sign){
                dfs(num,str+num.substring(index,i)+si,i,target);
            }
        }
    }
    public int getVal(String s) {
        if (s == null || s.isEmpty())
            return 0;
        char sign ='+';
        int num =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length()+1; i++){
            //最后加一位是为了促使完成最后数的处理  例如3-1
            char c = i==s.length()? '+' :s.charAt(i);
            if(c == ' ')
                continue;
            else if(Character.isDigit(c)){
                num = num*10 + (c-'0');
                continue;
            }else{
                if(sign == '+'){
                    stack.push(num);
                }else if(sign =='-'){
                    stack.push(-num);
                }else if(sign =='*'){
                    int tmp = stack.pop() * num;
                    stack.push(tmp);
                }else if(sign =='/'){
                    int tmp = stack.pop() /num;
                    stack.push(tmp);
                }
                num =0;
                sign =c;
            }
        }
        int res =0;
        while(!stack.isEmpty())
            res += stack.pop();
        return res;
    }


}
