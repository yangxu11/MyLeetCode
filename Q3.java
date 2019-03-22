package leetcode;

//无重复的最长子串
public class Q3 {

    //最优解
    //i为当前遍历过的字符串中未出现重复的最小下标，如果index[s.charAt(j)]>i说明i之后开始出现重复的s.charAt(j)，所以i后移
    //此时比较最长
    //记录s.charAt(j)最大的下标
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


//    执行用时 : 51 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了69.67% 的用户
//    内存消耗 : 49.5 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了12.52% 的用户

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        int start = 0;
        int end = 1;
        int res = 0;
        while(end<s.length()){
            for(int i=start ; i<end ; i++){
                if(s.charAt(i)==s.charAt(end)){
                    res = Math.max(end-i,res);
                    start = i+1;
                    break;
                }
            }
            res = Math.max(end-start+1,res);
            end++;
        }
        return res;
    }
}
