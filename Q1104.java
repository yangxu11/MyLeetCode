package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yx
 * @create 2019-09-30  15:19
 **/
public class Q1104 {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
    }
    public static List<Integer> pathInZigZagTree(int label) {
        int step = 1;

        while(step*2-1 <label){
            step*=2;
        }

        List<Integer> res = new ArrayList<>();

        int end = step*2 - 1;
        int start = step;

        end = start-1;
        start = step/2;

        int cur = label;
        res.add(label);

        while(cur>0 && start>0){
            int num = cur/2;
            cur = start+(end-num);
            end = start-1;
            start = start/2;
            res.add(0,cur);
        }

        return res;
    }
}