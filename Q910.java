package leetcode;

import java.util.Arrays;
//最小差值II
public class Q910 {
    //先将数组排序 对于每一个A[i] 和 A[i + 1] 比较 min+K、A[i]+K、max-K、A[i+1]-K之间的大小即可
    public int smallestRangeII(int[] A, int K) {
        if(A.length == 1) {
            return 0;
        }

        Arrays.sort(A);
        int len = A.length;

        int res = A[len - 1] - A[0];

        for (int i = 0; i < len - 1; i++) {
            int max = Math.max(A[i] + K, A[len - 1] - K);
            int min = Math.min(A[i + 1] - K, A[0] + K);
            res = Math.min(res, max - min);
        }

        return res;
    }
}
