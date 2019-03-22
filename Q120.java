package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//三角形最小路径和
public class Q120 {
    //7ms 77% O(n)的额外空间
    //从上而下的计算，得到每层每个点相对于上层相邻两个点的最小值，只保留一层的值
    // 取最后一层的最小值
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        List<Integer> mins = triangle.get(0);

        for(int i=1 ; i<triangle.size() ; i++){
            List<Integer> layer = triangle.get(i);
            List<Integer> list = new ArrayList<>();
            list.add(mins.get(0)+layer.get(0));
            for(int j=1 ; j<layer.size()-1 ; j++){
                list.add(Math.min(mins.get(j-1),mins.get(j))+layer.get(j));
            }
            list.add(mins.get(mins.size()-1)+layer.get(layer.size()-1));
            mins=list;
        }
        return Collections.min(mins);
    }
    //14ms 18%  O(n^2)的额外空间
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        List<List<Integer>> mins = new ArrayList<>();
        mins.add(triangle.get(0));

        for(int i=1 ; i<triangle.size() ; i++){
            List<Integer> layer = triangle.get(i);
            List<Integer> list = new ArrayList<>();
            list.add(mins.get(i-1).get(0)+layer.get(0));
            for(int j=1 ; j<layer.size()-1 ; j++){
                list.add(Math.min(mins.get(i-1).get(j-1),mins.get(i-1).get(j))+layer.get(j));
            }
            list.add(mins.get(i-1).get(mins.get(i-1).size()-1)+layer.get(layer.size()-1));
            mins.add(list);
        }
        return Collections.min(mins.get(mins.size()-1));
    }
}
