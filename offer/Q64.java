package leetcode.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 *
 * @author yx
 * @create 2019-05-11  11:55
 **/
public class Q64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a<b ? 1 :( a==b ? 0 : -1);
            }
        });
        if(num.length<size || size==0) return res;
        for(int i=0 ; i<size ; i++){
            queue.add(num[i]);
        }
        res.add(queue.peek());
        for(int i=size ; i<num.length ; i++){
            queue.remove(num[i-size]);
            queue.add(num[i]);
            res.add(queue.peek());
        }
        return res;
    }
}
