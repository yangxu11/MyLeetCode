package leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author yx
 * @create 2019-05-11  11:42
 **/
public class Q63 {
    PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer a, Integer b) {
            return a<b ? 1 :( a==b ? 0 : -1);
        }
    });
    int count=0;
    PriorityQueue<Integer> max = new PriorityQueue<>();

    public void Insert(Integer num) {
        int sign = (++count)%2;
        if(sign == 1){
            if(min.isEmpty()){
                min.add(num);
            } else{
                if(num > max.peek()){
                    min.add(max.poll());
                    max.add(num);
                } else{
                    min.add(num);
                }
            }
        } else{
            if(num < min.peek()){
                max.add(min.poll());
                min.add(num);
            } else{
                max.add(num);
            }
        }
    }

    public Double GetMedian() {
        if(count%2==0){
            return (min.peek() + max.peek())/2.0;
        } else{
            return (double)min.peek();
        }
    }
}
