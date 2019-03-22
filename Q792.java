package leetcode;

import java.util.HashMap;

//匹配子序列中的单词数
public class Q792 {
    //执行用时: 58 ms, 在Number of Matching Subsequences的Java提交中击败了94.22% 的用户
    //内存消耗: 41 MB, 在Number of Matching Subsequences的Java提交中击败了64.00% 的用户

    //思路同解法2，但是要建立一个map存储已经出现过的单词
    public int numMatchingSubseq1(String S, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0, count = 0;
        boolean sub;
        for (String word : words) {
            if (map.containsKey(word)) {
                count += map.get(word);
            } else {
                index = -1;
                sub = true;
                for (int i = 0; i < word.length(); i++) {
                    index = S.indexOf(word.charAt(i), index + 1);
                    if (index < 0) {
                        sub = false;
                        break;
                    }
                }
                if (sub) {
                    count++;
                    map.put(word, 1);
                } else {
                    map.put(word, 0);
                }
            }
        }
        return count;
    }
    //执行用时: 644 ms, 在Number of Matching Subsequences的Java提交中击败了28.93% 的用户
    //内存消耗: 41 MB, 在Number of Matching Subsequences的Java提交中击败了64.00% 的用户

    //暴力法，使用Q392（判断子序列）的方法判断子序列，然后得出个数
    public int numMatchingSubseq2(String S, String[] words) {
        int res = 0;
        for(String s : words){
            if(isSubsequence(s,S)){
                res++;
            }
        }
        return res;
    }
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c,index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
