package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author yx
 * @create 2019-04-17  17:41
 **/
public class Q295 {
    //采用双堆，小堆逆向排序，堆顶为最大值，大堆堆顶为最小值
    //每次加入元素时，分奇数和偶数，判断堆顶元素
    //奇数时，加入小堆，判断当前元素是否小于大堆的最小值，否则将大堆的堆顶加入小堆，当前值入大堆
    //偶数时，加入大堆，判断当前元素是否大于小堆最大值，否则将小堆堆顶加入大堆，当前值入小堆

    //提前中位数时，判断奇数偶数
    class MedianFinder {
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;
        int count;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxQueue = new PriorityQueue<>();
            Comparator<Integer> comp = new Comparator<Integer>(){
                public int compare(Integer a,Integer b){
                    return a<b ? 1 : (a==b ? 0 : -1);
                }
            };
            minQueue = new PriorityQueue<>(comp);
        }

        public void addNum(int num) {
            ++count;
            if((count&1) == 1){
                if(minQueue.isEmpty()){
                    minQueue.add(num);
                } else{
                    if(num>maxQueue.peek()){
                        minQueue.add(maxQueue.poll());
                        maxQueue.add(num);
                    } else{
                        minQueue.add(num);
                    }
                }
            } else{

                if(num<minQueue.peek()){
                    maxQueue.add(minQueue.poll());
                    minQueue.add(num);
                } else{
                    maxQueue.add(num);
                }
            }
        }

        public double findMedian() {
            if(count==0) return 0;
            if((count&1) == 1){
                return minQueue.peek();
            } else{
                return ((double)minQueue.peek() + (double)maxQueue.peek())/2;
            }
        }
    }
}
