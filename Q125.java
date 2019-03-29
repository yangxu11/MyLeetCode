package leetcode;

/**
 * 验证回文串
 *
 * @author yx
 * @create 2019-03-29  20:52
 **/
public class Q125 {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        s= s.toLowerCase();

        int start=0;
        int end = s.length()-1;

        while(end>start) {
            while(!((s.charAt(start)>='a' && s.charAt(start)<='z')||(s.charAt(start)>='0' && s.charAt(start)<='9')) && end>start) {
                start++;
            }
            while(!((s.charAt(end)>='a' && s.charAt(end)<='z')||(s.charAt(end)>='0' && s.charAt(end)<='9')) && end>start) {
                end--;
            }
            if(end==start) break;
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
