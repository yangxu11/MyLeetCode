package leetcode;
//最长回文子字符串
public class Q5 {
    //23ms 76%
    //以一个遍历到的当前字符为中心，寻找最长的回文子字符串，注意奇数和偶数,记录最长子字符串的首尾位置
    //是解法2的简化版
    public String longestPalindrome1(String s) {
        if(s.length()==0) return "";
        int start = 0;
        int end=0;

        for(int i=0 ; i<s.length()-1 ; i++){
            int len1 = center(s,i,i);
            int len2 = center(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start+1){
                end = i+len/2;
                start = i-(len-1)/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int center(String s,int L,int R){
        while(L>=0 && R<=s.length()-1 && s.charAt(L) ==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;//最后的R和L不符合条件
    }
}
