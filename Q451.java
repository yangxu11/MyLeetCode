package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//根据字符出现频率排序
public class Q451 {

    public String frequencySort(String s) {
        if(s==null) return null;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    public int compare(Map.Entry<Character, Integer> o1,
                                       Map.Entry<Character, Integer> o2) {
                        return o1.getValue()<o2.getValue() ? 1 : (o1.getValue()==o2.getValue() ? 0 : -1);
                    }
                }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<map.size() ; i++) {
            Map.Entry entry = pq.poll();
            for(int j=0 ; j<(int)entry.getValue() ; j++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();

    }

}
