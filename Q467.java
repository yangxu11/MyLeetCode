package leetcode;

public class Q467 {
    //执行用时: 24 ms, 在Unique Substrings in Wraparound String的Java提交中击败了28.45% 的用户
    //内存消耗: 27.7 MB, 在Unique Substrings in Wraparound String的Java提交中击败了46.67% 的用户

    //建立一个数组dp存储以每个字母为结尾的最长字符串的长度，则以该字符为结尾的字符串数量为该长度
    //最后求其总和
    public int findSubstringInWraproundString(String p) {
        if(p.length()==0) return 0;
        int[] dp = new int[26];
        char pre = p.charAt(0);
        dp[pre-'a'] = 1;
        int len = 1;

        for(int i=1 ; i<p.length() ; i++){
            //dp[p.charAt(i)-'a']  = Math.max(dp[p.charAt(i)-'a'],1);
            if(p.charAt(i)-p.charAt(i-1)==1 ||(p.charAt(i)=='a'&&p.charAt(i-1)=='z')){
                len++;
            } else {
                len=1;
            }
            dp[p.charAt(i)-'a']  = Math.max(dp[p.charAt(i)-'a'],len);
        }
        int result = 0;
        for(int i : dp){
            result += i;
        }
        return result;
    }
//执行用时: 19 ms, 在Unique Substrings in Wraparound String的Java提交中击败了48.28% 的用户
//内存消耗: 31.5 MB, 在Unique Substrings in Wraparound String的Java提交中击败了33.33% 的用户

    //思路相同
    public int findSubstringInWraproundString2(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] ways = new int[125];
        char[] cs = p.toCharArray();
        int left = 0;
        int right = 1;
        // NOTE: even if right == cs.length, can still go into the loop, to handle the "a" case (single char)
        while (right <= cs.length) {
            while (right < cs.length && ((cs[right] - cs[right-1] == 1) || (cs[right] == 'a' && cs[right-1] == 'z'))) {
                right++;
            }
            while (left < right) {
                ways[cs[left]] = Math.max(ways[cs[left]], right - left);
                left++;
            }
            right++;
        }
        int sum = 0;
        for (int way : ways) {
            sum += way;
        }
        return sum;
    }
}
