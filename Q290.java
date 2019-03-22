package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q290 {

    public boolean wordPattern(String pattern, String str) {

        Map<Character,String> map = new HashMap<>();
        String[] strs = str.split(" ");
        Set<String> values = new HashSet<>();

        for(int i=0 ; i<pattern.length() ; i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if(!strs[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i),strs[i]);
                if(!values.add(strs[i])) return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        Q290 q = new Q290();
        System.out.println(q.wordPattern(pattern,str));
    }
}
