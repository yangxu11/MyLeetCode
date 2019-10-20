package leetcode;

/**
 * 替换子串得到平衡字符串
 *
 * @author yx
 * @create 2019-10-20  12:16
 **/
public class Q5232 {
    public int balancedString(String s) {
        int q = 0, w = 0, e = 0, r = 0;
        int n = s.length(), t = n / 4;

        for (char ch : s.toCharArray()) {
            if (ch == 'Q') q++;
            if (ch == 'W') w++;
            if (ch == 'E') e++;
            if (ch == 'R') r++;
        }

        if (q == w && w == e && e == r) return 0;
        int lo = 0, ans = Integer.MAX_VALUE;
        for (int hi = 0; hi < n; hi++) {
            char c = s.charAt(hi);
            if (c == 'Q') q--;
            if (c == 'W') w--;
            if (c == 'E') e--;
            if (c == 'R') r--;
            if (q > t || w > t || e > t || r > t) continue;
            while (lo <= hi && q <= t && w <= t && e <= t && r <= t) {
                char x = s.charAt(lo++);
                if (x == 'Q') q++;
                if (x == 'W') w++;
                if (x == 'E') e++;
                if (x == 'R') r++;
            }
            ans = Math.min(hi-lo+2, ans);
        }
        return ans;


    }
}
