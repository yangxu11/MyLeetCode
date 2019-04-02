package leetcode;

/**
 * 最小的栈
 *
 * @author yx
 * @create 2019-04-02  17:24
 **/
public class Q155 {
    class MinStack {

        int[] stack;
        int capacity;
        int top;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            capacity = 10;
            stack = new int[capacity];
            top=0;
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            check();
            stack[top++] = x;
            if(min>x){
                stack[top++] = x;
                min = x;
            } else{
                stack[top++] = min;
            }
        }

        public void pop() {
            if(top==0) return;
            top -= 2;
            if(top==0){
                min = Integer.MAX_VALUE;
            } else{
                min = stack[top-1];
            }

        }

        public int top() {
            if(top==0) return -1;
            return stack[top-2];
        }

        public int getMin() {
            if(top==0) return -1;
            return stack[top-1];
        }
        public void check(){
            if(top == capacity-1 || top == capacity-2){
                int[] newStack = new int[capacity<<1];
                for(int i=0 ; i<capacity ; i++){
                    newStack[i] = stack[i];
                }
                stack = newStack;
                capacity <<= 1;
            }
        }
    }

}
