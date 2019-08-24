package leetcode;

import java.util.Arrays;

/**
 * 分割数组
 *
 * @author yx
 * @create 2019-08-24  16:20
 **/
public class Q915 {
    public static void main(String[] args) {
        Q915 q = new Q915();
        int[] a = {1,1,1,0,6,12};
        System.out.println(q.partitionDisjoint(a));
    }
    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] max = new int[len];
        int[] min = new int[len];

        int max1 = A[0];
        for(int i=0 ; i<len ; i++){
            max1 = Math.max(max1,A[i]);
            max[i] = max1;
        }
        int min1 = A[len-1];
        for(int i=len-1 ; i>=0 ; i--){
            min1 = Math.min(min1,A[i]);
            min[i] = min1;
        }
        for(int i=0 ; i<len-1 ; i++){
            if(max[i]<=min[i+1]){
                return i+1;
            }
        }
        System.out.println(Arrays.toString(min));
        System.out.println(Arrays.toString(max));
        return -1;
    }
}
