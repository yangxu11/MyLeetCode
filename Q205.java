package leetcode;

import java.util.HashMap;
//同构字符串
public class Q205 {


    //最优解，使用数组来代替哈希表
    //必须倒序遍历，防止首位为0的情况，数组初始化时所有值为0
    public boolean isIsomorphic1(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] map = new int[512];
        for (int i = sc.length-1;i >=0;i--) {
            if (map[sc[i]] != map[tc[i]+256]) {
                return false;
            }
            map[sc[i]] = map[tc[i] + 256] = i;
        }
        return true;

    }



    public boolean isIsomorphic2(String s, String t) {
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
