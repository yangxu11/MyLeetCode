package leetcode;

import java.util.*;

//根据字符出现频率排序
public class Q451 {

    public String frequencySort(String s) {
        int[] cs = new int[128];

        for(int i=0 ; i<s.length() ; i++){
            cs[s.charAt(i)] += 1;
        }

        Map<Integer, List<Character>> map = new HashMap<>();

        for(int i=0 ; i<128 ; i++){
            if(cs[i]>0){
                List<Character> list = map.getOrDefault(cs[i],new ArrayList<>());
                list.add((char)i);
                map.put(cs[i],list);
            }
        }

        PriorityQueue<Map.Entry<Integer,List<Character>>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,List<Character>>>(){
            public int compare(Map.Entry<Integer,List<Character>> a,Map.Entry<Integer,List<Character>> b){
                return a.getKey()<b.getKey() ? 1 : (a.getKey()==b.getKey() ? 0 : -1);
            }
        });
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Integer,List<Character>> entry = pq.poll();
            List<Character> list = entry.getValue();
            int num = entry.getKey();
            for(char c : list){
                for(int i=0 ; i<num ; i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
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



    public static void main(String[] args) {
        String s = "stee";
        Q451 q = new Q451();
        System.out.println(q.frequencySort2(s));
    }

}
