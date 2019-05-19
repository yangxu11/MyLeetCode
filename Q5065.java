package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长字符串链
 *
 * @author yx
 * @create 2019-05-19  11:03
 **/
public class Q5065 {
    static Set<String> set;
    static int maxLen;
    static Map<String, Integer> map;

    public int longestStrChain(String[] words) {

        set = new HashSet<>(words.length);
        map = new HashMap<>();
        for (String word : words) {
            set.add(word);
            maxLen = Math.max(word.length(), maxLen);
        }

        int res = 0;
        for (String word : words) {
            res = Math.max(res, method(word, 1));
        }

        return res;

    }

    private int method(String word, int len) {

        if (word.length() >= maxLen) {
            return len;
        }

        if (map.containsKey(word)) {
            return len + map.get(word);
        }

        int res = len;

        for (int i = 0; i <= word.length(); i++) {

            for (char c = 'a'; c <= 'z'; c++) {

                StringBuilder temp = new StringBuilder(word);
                temp = temp.insert(i, c);

                if (set.contains(temp.toString())) {
                    res = Math.max(res, method(temp.toString(), len + 1));
                    map.put(temp.toString(), res - len - 1);
                }
            }
        }

        return res;
    }
}
