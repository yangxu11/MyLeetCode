package leetcode.offer;

import java.util.ArrayList;

/**
 * 栈的压入和弹出
 *
 * @author yx
 * @create 2019-05-04  11:05
 **/
public class Q21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        ArrayList<Integer> stack = new ArrayList<>();
        int n = pushA.length;
        int push = 0;

        for(int i=0 ; i<n ; i++){
            if(!stack.isEmpty() && stack.get(stack.size()-1)==popA[i]){
                stack.remove(stack.size()-1);
            } else{
                int j=push ;
                for(; j<n ; j++){
                    if(pushA[j] == popA[i]){
                        push  = j+1;
                        break;
                    } else{
                        stack.add(pushA[j]);
                    }
                }
                if(j == n) return false;
            }

        }
        return true;

    }
}
