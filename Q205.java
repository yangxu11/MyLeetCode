package leetcode;

import java.util.HashMap;
//同构字符串
public class Q205 {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        if(s.length() != t.length()) return false;

        for(int i=0 ; i<s.length() ; i++) {
            if(map.containsKey(s.charAt(i))) {
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            } else {
                if(map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        return true;
    }

}
