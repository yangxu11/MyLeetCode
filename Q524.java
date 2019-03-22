package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q524 {

    public String findLongestWord(String s, List<String> d) {
        if (d.isEmpty() || s.length() == 0) return "";
        Collections.sort(d, new StringComparator());
        for (String d1 : d) {
            int flag = 0;
            int index = -1;
            for (int i = 0; i < d1.length(); i++) {
                for (int j = index + 1; j < s.length(); j++) {
                    if ((j == s.length() - 1 && i != d1.length() - 1) ||
                            (j == s.length() - 1 && i == d1.length() - 1 && d1.charAt(i) != s.charAt(j))) {
                        flag = 1;
                    }
                    if (d1.charAt(i) == s.charAt(j)) {
                        index = j;
                        break;
                    }
                }

            }
            if (flag == 0) return d1;
        }
        return "";
    }
}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return 1;
        } else if (o1.length() > o2.length()) {
            return -1;
        } else {
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) > o2.charAt(i)) return 1;
                if (o1.charAt(i) < o2.charAt(i)) return -1;
            }
            return 0;
        }
    }

}
