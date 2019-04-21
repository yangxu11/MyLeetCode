package leetcode;

/**
 * 两个非重叠子数组的最大和
 *
 * @author yx
 * @create 2019-04-21  11:19
 **/
public class Q1031 {
    public static void main(String[] args) {
        int[] a = {0,6,5,2,2,5,1,9,4};
        Q1031 q = new Q1031();
        System.out.println(q.maxSumTwoNoOverlap(a,1,2));
    }
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] sumL = new int[n-L+1];
        int[] sumM = new int[n-M+1];

        int sum0 = 0;
        for(int i=0 ; i<L ; i++){
            sum0+=A[i];
        }
        sumL[0] = sum0;
        for(int i=1 ; i<n-L+1 ; i++){
            sum0 = sum0-A[i-1]+A[i+L-1];
            sumL[i] = sum0;
        }
        sum0 = 0;
        for(int i=0 ; i<M ; i++){
            sum0+=A[i];
        }
        sumM[0] = sum0;
        for(int i=1 ; i<n-M+1 ; i++){
            sum0 = sum0-A[i-1]+A[i+M-1];
            sumM[i] = sum0;
        }

        int res = 0;
        for(int i=0 ; i<sumL.length-M ; i++){
            for(int j=0 ; j+M-1<i ; j++){
                res = Math.max(sumL[i]+sumM[j],res);
            }
            for(int j=i+L ; j<sumM.length ; j++){
                res = Math.max(sumL[i]+sumM[j],res);
            }
        }
        return res;
    }
}
