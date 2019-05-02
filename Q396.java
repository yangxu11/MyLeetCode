package leetcode;

/**
 * 旋转函数
 *
 * @author yx
 * @create 2019-05-02  10:37
 **/
public class Q396 {
    //找规律，下一个和 相当于前面的pre+sum - 末尾值*n
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if(n<=1) return 0;
        int res = 0;
        int pre = res;
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            sum += A[i];
            res += i*A[i];
        }
        pre = res;
        for(int i=n-1 ; i>0 ; i--){
            long tmp = pre - n*A[i] + sum;
            res = Math.max(res,(int)tmp);
            pre = (int)tmp;
        }
        return res;

    }
}
