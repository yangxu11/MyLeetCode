package leetcode;

import java.util.List;
//单词拆分
public class Q139 {
    //执行用时: 18 ms, 在Word Break的Java提交中击败了51.15% 的用户
    //内存消耗: 28.4 MB, 在Word Break的Java提交中击败了53.68% 的用户

    //同   不同的二叉搜索树II 思路相同
    //如果字符串能够拆分，则在i处可拆分成s.substring(0,i+1) + wordDict中有的一个单词，
    // 其中s.substring(0,i+1)为之前已经得到的结果，可以拆分，有一种满足条件即可break
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n+1];
        canBreak[0] = true;

        for(int i=1 ; i<=n ; i++){
            for(int j=0 ; j<i ; j++){
                if(canBreak[j]&&wordDict.contains(s.substring(j,i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[n];
    }
    //解法1改进
    //执行用时: 8 ms, 在Word Break的Java提交中击败了86.54% 的用户
    //内存消耗: 21.4 MB, 在Word Break的Java提交中击败了85.29% 的用户
    //j每次并不需要从0开始搜索。因为wordDict中的字符串长度是有限的。只需要从i-maxWordLength(最长的单词长度)开始搜索就可以了。
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n+1];
        canBreak[0] = true;
        int max = 0;

        for(String str : wordDict){
            max = Math.max(max,str.length());
        }

        for(int i=1 ; i<=n ; i++){
            for(int j=Math.max(0,i-max) ; j<i ; j++){
                if(canBreak[j]&&wordDict.contains(s.substring(j,i))){
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[n];
    }
}
