package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//第三大的数
public class Q414 {
    //3ms 92%  使用Long来解决初始三个数的值，如果用int，在数组中出现Integer.MIN_VALUE时不好判断
    public int thirdMax1(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;


        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==first || nums[i]==second || nums[i]==third){
                continue;
            }
            if(nums[i]>first){
                third = second;
                second = first;
                first = nums[i];
            } else if(nums[i]>second){
                third = second;
                second = nums[i];
            } else if(nums[i]>third){
                third = nums[i];
            }
        }

        return (int)(third==Long.MIN_VALUE ? first : third);

    }


    public int thirdMax2(int[] nums) {
        if(nums.length==0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0 ; i<nums.length ; i++){
            if(!set.add(nums[i])){
                continue;
            }
            if(queue.size()<3){
                queue.offer(nums[i]);
            } else{
                if(queue.peek()<nums[i]){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        int res = 0;
        if(queue.size()<3){
            while(!queue.isEmpty()){
                res = queue.poll();
            }
        } else{
            res = queue.peek();
        }
        return res;
    }


}
