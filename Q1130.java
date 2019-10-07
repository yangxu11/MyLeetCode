package leetcode;

import java.util.Stack;

/**
 * 叶值的最小代价生成树
 *
 * @author yx
 * @create 2019-10-07  17:16
 **/
public class Q1130 {
    //动态规划
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;

        int[][] dp = new int[len][len];
        int[][] max = new int[len][len];

        for(int i=0 ; i<len ; i++){
            int max1 = arr[i];
            for(int j=i ; j<len ; j++){
                if(arr[j]>max1){
                    max1 = arr[j];
                }
                max[i][j] = max1;
                if(i!=j) dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int step = 1 ; step<len ; step++){
            for(int i=0 ; i+step<len ; i++){
                for(int j=i ; j<i+step ; j++){
                    dp[i][i+step] = Math.min(dp[i][i+step],(dp[i][j]+dp[j+1][i+step]+max[i][j]*max[j+1][i+step]));
                }
            }
        }


        return dp[0][len-1];

    }

    //单调栈
    public int mctFromLeafValues1(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        int res = 0;

        for(int i=0 ; i<arr.length ; i++){
            while(arr[i]>=stack.peek()){
                int mid = stack.pop();
                res += mid*Math.min(stack.peek(),arr[i]);
            }
            stack.push(arr[i]);
        }
        while(stack.size()>2){
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
