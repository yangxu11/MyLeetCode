package leetcode;

import java.util.Stack;

/**
 * 下一个更大的元素II
 *
 * @author yx
 * @create 2019-05-31  18:16
 **/
public class Q503 {
    //思路同Q496
    //使用栈，栈中存储的是数组的下标
    //遍历数组，栈顶坐标对应的数值如果小于当前值，则当前值就是答案，出栈并存储res[stack.pop()] = nums[i];
    //遍历完一圈后，如果栈不为空，此时栈中元素为自顶向下递增，再遍历一遍，最后将剩下的赋值为-1
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];

        Stack<Integer> stack = new Stack();

        for(int i=0 ; i<nums.length ; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            for(int i=0 ; i<nums.length ; i++){
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    res[stack.pop()] = nums[i];
                }
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }
        return res;
    }
}
