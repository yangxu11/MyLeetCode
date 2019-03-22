package leetcode;
//回文子串
public class Q647 {
    //执行用时: 12 ms, 在Palindromic Substrings的Java提交中击败了85.05% 的用户
    //内存消耗: 23.5 MB, 在Palindromic Substrings的Java提交中击败了71.05% 的用户

    //思路同Q5（最长回文子字符串）
    //遍历字符串s，以当前字符为中心寻找回文子串，注意奇数和偶数，累计得到结果
    public int countSubstrings(String s) {
        int res = 0;

        for(int i=0 ; i<s.length() ; i++){
            int num1 = getNum(s,i,i);
            int num2 = getNum(s,i,i+1);

            res += num1 + num2;
        }
        return res;
    }

    public int getNum(String s,int L,int R){
        int count = 0;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
            count ++;
        }
        return count;
    }
}
