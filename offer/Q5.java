package leetcode.offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author yx
 * @create 2019-05-03  11:32
 **/
public class Q5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack1.isEmpty()){
            stack1.push(node);
        } else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
