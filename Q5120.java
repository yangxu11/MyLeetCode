package leetcode;

import java.util.Stack;

/**
 * 有效括号的嵌套深度
 *
 * @author yx
 * @create 2019-07-07  15:49
 **/
public class Q5120 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];

        Stack<int[]> stack = new Stack<>();
        int flag = 0;

        for(int i=0 ; i<seq.length() ; i++){
            char c = seq.charAt(i);
            if(c == '('){
                stack.push(new int[]{i,flag});
                flag = 1-flag;
            } else{
                int[] tmp = stack.pop();
                res[tmp[0]] = tmp[1];
                res[i] = tmp[1];
                flag = 1-flag;
            }
        }

        return res;
    }
}
