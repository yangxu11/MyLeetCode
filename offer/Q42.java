package leetcode.offer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 *
 * @author yx
 * @create 2019-05-07  20:17
 **/
public class Q42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array.length<=1) return res;

        int start = 0;
        int end = array.length-1;

        while(start<end){
            int num = array[start] + array[end];
            if(num < sum){
                while(start+1<end && array[start]==array[start+1]){
                    ++start;
                }
                ++start;
            } else if(num > sum){
                while(end-1>start && array[end]==array[end-1]){
                    --end;
                }
                --end;
            } else{
                if(res.isEmpty()){
                    res.add(array[start]);
                    res.add(array[end]);
                } else{
                    if(array[start]*array[end]<res.get(0)*res.get(1)){
                        res.clear();
                        res.add(array[start]);
                        res.add(array[end]);
                    }
                }
                while(start+1<end && array[start]==array[start+1]){
                    ++start;
                }
                ++start;
                while(end-1>start && array[end]==array[end-1]){
                    --end;
                }
                --end;
            }
        }
        return res;
    }
}
