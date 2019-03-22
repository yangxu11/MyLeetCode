package leetcode;

import java.util.*;

//最短完整单词
public class Q748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character,Integer> map = new HashMap<>();

        List<String> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        String word="";
        for(int i=0 ; i<licensePlate.length() ; i++ ) {
            char c = licensePlate.charAt(i);
            char c1 = Character.toLowerCase(c);
            if((c>='a'&&c<='z') ||(c>='A'&&c<='Z') ) {
                if(map.containsKey(c1)) {
                    map.put(c1,map.get(c1)+1);
                } else {
                    map.put(c1,1);
                }
            }
        }
        for(int i=0 ; i<words.length ; i++) {
            Map<Character,Integer> map1 = new HashMap<>(map);
            String str = words[i];
            int flag=0;
            for(int j=0 ; j<str.length() ; j++) {
                if(map1.containsKey(str.charAt(j)) && map1.get(str.charAt(j))>0) {
                    map1.put(str.charAt(j),map1.get(str.charAt(j))-1);
                }
            }
            for(Character c : map1.keySet()) {
                if(map1.get(c)!=0) {
                    flag=1;
                    break;
                }
            }
            if(flag == 0) {
                list.add(str);
                min = Math.min(min,str.length());
            }
        }
        for(String str : list) {
            if(str.length() == min) {
                word=str;
                break;
            }
        }
        return word;

    }

    public static void main(String[] args) {
        Q748 q = new Q748();
        String l = "GrC8950";
        String[] words = {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
        System.out.println(q.shortestCompletingWord(l,words));
    }
}
