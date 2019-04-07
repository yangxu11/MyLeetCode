package leetcode;

import java.util.PriorityQueue;

/**
 * 数组中第K个最大元素
 *
 * @author yx
 * @create 2019-04-06  11:14
 **/
public class Q215 {
    //堆
    public int findKthLargest(int[] nums, int k) {
//        Comparator comp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return a<b ? 1 : (a==b ? 0 : -1);
//            }
//        };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<nums.length ; i++){
            if(pq.size()<k){
                pq.add(nums[i]);
            } else{
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
