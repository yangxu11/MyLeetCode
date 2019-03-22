package leetcode;

import java.util.ArrayList;
import java.util.List;
//找到字符串中所有字母异位词
public class Q438 {
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new ArrayList<>();
//        if(s.length()<p.length()) return list;
//        int start =0;
//        int end = p.length()-1;
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0 ; i<p.length() ; i++) {
//            char c = p.charAt(i);
//            if(map.containsKey(c)) {
//                map.put(c,map.get(c)+1);
//            } else {
//                map.put(c,1);
//            }
//        }
//        for(int i=0 ; i<s.length()-p.length()+1 ; i++) {
//            int flag = 0;
//            Map<Character,Integer> map1 = new HashMap<>(map);
//            for(int j=i ; j<i+p.length() ; j++) {
//                char c = s.charAt(j);
//                if(map1.containsKey(c) && map1.get(c)>0) {
//                    map1.put(c,map.get(c)-1);
//                } else {
//                    flag =1;
//                    break;
//                }
//
//            }
//            if(flag==0) {
//                list.add(i);
//            }
//
//        }
//        return list;
//
//
//    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;

        int[] hash = new int[256];

        for (char i : p.toCharArray()) {
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length(); // 差异度

        while (right < s.length()) {

            // 窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，
            // 表示当前字符包含在 p 字符串中，所以差异度减一
            if (hash[s.charAt(right)] > 0) {
                count--;
            }
            hash[s.charAt(right)] --;
            right ++;

            // 差异度为0，加入结果集合中
            if (count == 0)
                result.add(left);

            // 如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，
            // 将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，
            // 所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
            if (right - left == p.length()) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)] ++;
                left ++;
            }
        }
        return result;
    }
}
