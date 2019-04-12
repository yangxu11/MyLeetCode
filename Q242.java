package leetcode;

/**
 * 有效的字母异位词
 *
 * @author yx
 * @create 2019-04-12  17:29
 **/
public class Q242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] letters = new int[26];

        for(int i=0 ; i<s.length() ; i++){
            letters[s.charAt(i)-'a'] += 1;
        }

        for(int i=0 ; i<t.length() ; i++){
            if(letters[t.charAt(i)-'a']<=0) {
                return false;
            }
            letters[t.charAt(i)-'a'] -=1;
        }

        return true;
    }
}
