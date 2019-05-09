package leetcode.offer;

/**
 * 构建乘积数组
 *
 * @author yx
 * @create 2019-05-09  18:21
 **/
public class Q51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length==0) return B;
        B[0] = A[0];
        int sum = 1;
        for(int i=0 ; i<A.length ; i++){
            B[i] = sum;
            sum *= A[i];
        }
        sum = 1;
        for(int i=A.length-1 ; i>=0 ; i--){
            B[i] *= sum;
            sum *= A[i];
        }
        return B;
    }
}
