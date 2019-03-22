package leetcode;

import java.util.Arrays;
import java.util.Stack;
//每日温度
public class Q739 {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Entry> stack = new Stack<Entry>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Entry(temperatures[i], i));
                continue;
            }
            if (temperatures[i] <= stack.peek().val) stack.push(new Entry(temperatures[i], i));
            else {
                int j = 1;
                while (!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                    Entry tmp = stack.pop();
                    res[tmp.index] = i - tmp.index;
                }
                stack.push(new Entry(temperatures[i], i));
            }
        }

        return res;

    }

    private class Entry {

        public int val;
        public int index;

        public Entry(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Q739 q = new Q739();
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(q.dailyTemperatures(a)));
    }

}
