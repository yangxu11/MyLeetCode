package leetcode;

import java.util.*;

public class Q49 {
    //map 的键为排序后的字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            List<String> list = map.getOrDefault(str,new ArrayList<>());
            list.add(s);
            map.put(str,list);
        }
        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
