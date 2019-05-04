package leetcode.offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author yx
 * @create 2019-05-04  10:48
 **/
public class Q20 {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        min = Math.min(min,node);
        stack.push(node);
    }

    public void pop() {
        int num = stack.pop();
        if(num == min){
            min = Integer.MAX_VALUE;
            for(int n : stack){
                min = Math.min(n,min);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
