package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 图像重叠
 *
 * @author yx
 * @create 2019-08-10  16:19
 **/
public class Q835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length;

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                if(B[i][j]==1){
                    set.add(i*61 + j);
                }
                if(A[i][j]==1){
                    list.add(i*61 + j);
                }
            }
        }
        int res = 0;

        int start = -1*len;
        for(int i=start ; i<=len ; i++){
            for(int j=start ; j<=len ; j++){
                int num = i*61 + j;
                int count=0;
                for(int a : list){
                    if(set.contains(a+num)){
                        ++count;
                    }
                }
                res = Math.max(res,count);
            }
        }

        return res;
    }
}
