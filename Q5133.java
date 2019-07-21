package leetcode;

/**
 * 绝对值表达式的最大值
 *
 * @author yx
 * @create 2019-07-21  16:26
 **/
public class Q5133 {
    //分为四种情况来计算绝对值
    //每种情况保留最大值，来计算接下来的最大值
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans=0;
        int N=arr1.length;
        int t1=arr1[0]+arr2[0];
        int t2=-arr1[0]-arr2[0];
        int t3=arr1[0]-arr2[0];
        int t4=-arr1[0]+arr2[0];
        for(int i=1;i<N;i++){
            ans=Math.max(ans,t1+i-arr1[i]-arr2[i]);
            ans=Math.max(ans,t2+i+arr1[i]+arr2[i]);
            ans=Math.max(ans,t3+i-arr1[i]+arr2[i]);
            ans=Math.max(ans,t4+i+arr1[i]-arr2[i]);
            t1=Math.max(arr1[i]+arr2[i]-i,t1);
            t2=Math.max(-arr1[i]-arr2[i]-i,t2);
            t3=Math.max(arr1[i]-arr2[i]-i,t3);
            t4=Math.max(-arr1[i]+arr2[i]-i,t4);
        }
        return ans;
    }
}
