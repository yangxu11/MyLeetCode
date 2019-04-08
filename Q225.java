package leetcode;

import java.util.LinkedList;

/**
 * 队列实现栈
 *
 * @author yx
 * @create 2019-04-08  17:48
 **/
public class Q225 {
    class MyStack {

        LinkedList<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for(int i=0 ; i<size ; i++){
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
