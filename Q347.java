package leetcode;

import java.util.*;

//前K个高频词汇
public class Q347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i <nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()<o2.getValue() ? 1 : (o1.getValue()==o2.getValue() ? 0 : -1);//降序排列
            }
        });
        pq.addAll(map.entrySet());
        for(int i=0 ; i<k ; i++) {
            result.add(pq.poll().getKey());
        }
        return result;

    }
}
