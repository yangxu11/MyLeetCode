package leetcode.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小k个数
 *
 * @author yx
 * @create 2019-05-05  16:55
 **/
public class Q29 {
    //快排思想，左边的数都小于右边的数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if(k<=0){
            return res;
        }
        if(input.length==0||input.length<k){
            return res;
        }

        int start = 0;
        int end = input.length-1;

        int index = partition(input,start,end);

        while(index!=k-1){
            if(index>k-1){
                end = index-1;
                index = partition(input,start,end);
            } else {
                start = index+1;
                index = partition(input,start,end);
            }
        }
        for(int i=0 ; i<k ; i++){
            res.add(input[i]);
        }
        return res;
    }

    public int partition(int[] input,int start,int end){
        int target = input[start];

        while(start<end){
            while(start<end && input[end]>=target){
                end--;
            }
            input[start] = input[end];
            while(start<end && input[start]<=target){
                ++start;
            }
            input[end] = input[start];
        }
        input[start] = target;
        return start;
    }

    /*
     * @Author YX
     * 最大堆
     *
     **/

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x<y ? 1 : (x==y ? 0 : -1) ;
            }
        });
        for(int i=0 ; i<input.length ; i++){
            if(pq.size()<k){
                pq.offer(input[i]);
            } else{
                if(pq.peek()>input[i]){
                    pq.poll();
                    pq.offer(input[i]);
                }
            }
        }
        for(int i=0 ; i<k ; i++){
            res.add(pq.poll());
        }
        return res;
    }
}
