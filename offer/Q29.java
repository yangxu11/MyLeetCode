package leetcode.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小k个数
 *
 * @author yx
 * @create 2019-05-05  16:55
 **/
public class Q29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length<k) return res;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0 ; i<input.length ; i++){
            queue.add(input[i]);
        }

        for(int i=0 ; i<k ; i++){
            res.add(queue.poll());
        }
        return res;
    }
}
