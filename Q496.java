package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 下一个更大元素I
 *
 * @author yx
 * @create 2019-05-31  17:54
 **/
public class Q496 {
    //使用map来存储nums1中下一个更大元素的值
    //遍历nums2，判断当前值是否大于栈顶，如果大，说明当前值为栈顶的下一个更大元素，出栈，并且map赋值，如果小，入栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,-1);
        }

        Stack<Integer> stack = new Stack();
        for(int i=0 ; i<nums2.length ; i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0 ; i<nums1.length ; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
