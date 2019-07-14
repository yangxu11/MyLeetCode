package leetcode;

import java.util.*;

/**
 * 数组相对排序
 *
 * @author yx
 * @create 2019-07-14  10:36
 **/
public class Q5127 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] res = new int[arr1.length];
        int index = 0;
        int count = 0;
        for(int i=0 ; i<arr2.length ; i++){
            int num = map.get(arr2[i]);
            count+=num;
            for(int j=0 ; j<num ; j++){
                res[index] = arr2[i];
                index++;
            }
            map.remove(arr2[i]);
        }

        Set<Integer> set = map.keySet();
        int index1 = 0;
        int[] out = new int[arr1.length-count];
        for(int key : set){
            int num = map.get(key);
            for(int j=0 ; j<num ; j++){
                out[index1++] = key;
            }
        }
        Arrays.sort(out);
        for(int i=0 ; i<out.length ; i++){
            res[index] = out[i];
            index++;
        }

        return res;
    }
}
