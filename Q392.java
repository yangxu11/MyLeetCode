package leetcode;
//判断子序列
public class Q392 {
    //执行用时: 2 ms, 在Is Subsequence的Java提交中击败了96.06% 的用户
    //内存消耗: 42.6 MB, 在Is Subsequence的Java提交中击败了38.16% 的用户
    public boolean isSubsequence1(String s, String t) {
        int index = -1;
        for(char c : s.toCharArray()){
            index = t.indexOf(c,index + 1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }

    //执行用时: 34 ms, 在Is Subsequence的Java提交中击败了33.99% 的用户
    //内存消耗: 43.8 MB, 在Is Subsequence的Java提交中击败了22.37% 的用户
    public boolean isSubsequence2(String s, String t) {
        int len1 = 0;
        int len2 = 0;

        while(len1<s.length() && len2<t.length()){
            if(s.charAt(len1) == t.charAt(len2)){
                len1++;
            }
            len2++;
        }
        return len1==s.length();
    }
}
