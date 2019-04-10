package leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author yx
 * @create 2019-04-10  16:45
 **/
public class Q232 {
    //push时使用双栈
    class MyQueue {

        Stack<Integer> stack;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            int size = stack.size();
            if(size==0){
                stack.push(x);
            } else{
                Stack<Integer> tmp = new Stack<>();
                while(!stack.isEmpty()){
                    tmp.push(stack.pop());
                }
                stack.push(x);
                for(int i=0 ; i<size;i++){
                    stack.push(tmp.pop());
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
