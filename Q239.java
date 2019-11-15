package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author yx
 * @create 2019-11-05  20:05
 **/
public class Q239 {
    public static void main(String[] args) {
        Q239 q  =new Q239();
        int[] a = {1,-1};
        System.out.println(q.maxSlidingWindow(a,1));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comp = new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        int len = nums.length;
        if(len==0) return new int[0];
        int index=0;
        int[] res;
        if(len>=k){
            res = new int[len-k+1];
        } else{
            res = new int[1];
        }
        int count = k;
        while(index<len && count>0){
            pq.offer(nums[index++]);
            --count;
        }

        res[0] = pq.peek();
        int i=1;

        while(index<len){
            pq.remove(nums[index-k]);
            pq.offer(nums[index++]);
            res[i++] = pq.peek();
        }

        return res;
    }


}
