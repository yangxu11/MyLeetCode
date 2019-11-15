package leetcode;

import java.util.Stack;

/**
 * 去除重复字母
 *
 * @author yx
 * @create 2019-11-13  19:50
 **/
public class Q316 {
    public static void main(String[] args) {
        Q316 q = new Q316();
        System.out.println(q.removeDuplicateLetters("bcabc"));
    }
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(visited[c-'a']) continue;
            while(!stack.isEmpty() && c<stack.peek() && s.indexOf(stack.peek(),i)!=-1){
                char b = stack.pop();
                visited[b-'a'] = false;
            }
            stack.push(c);
            visited[c-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
