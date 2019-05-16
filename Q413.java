package leetcode;

/**
 * 等差数列的划分
 *
 * @author yx
 * @create 2019-05-16  18:12
 **/
public class Q413 {
    //滑动窗口
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;

        int diff = A[1]-A[0];
        int len=2;
        int res = 0;

        for(int i=2 ; i<A.length ; i++){
            if(A[i]-A[i-1] == diff){
                res += len-1;
                len++;
            } else{
                diff = A[i] - A[i-1];
                len = 2;
            }
        }
        return res;
    }
}
