package leetcode;

/**
 * 最小覆盖子串
 *
 * @author yx
 * @create 2019-10-22  20:01
 **/
public class Q76 {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int[] nums = new int[128];

        for(int i=0 ; i<t.length() ; i++){
            nums[t.charAt(i)] += 1;
        }

        int[] dp = new int[128];

        String res = "";
        int len = Integer.MAX_VALUE;
        int index = 0;

        for(int i=0 ; i<s.length() ; i++){
            dp[s.charAt(i)] += 1;
            if(!isValid(dp,nums)) continue;

            while(index<=i && isValid(dp,nums)){
                dp[s.charAt(index)] -= 1;
                index++;
            }
            if(len > (i-index+2)){
                len = i-index+2;
                res = s.substring(index-1,i+1);
            }
        }

        return res;
    }

    public boolean isValid(int[] dp , int[] nums){
        for(int i=0 ; i<128 ; i++){
            if(dp[i]<nums[i]){
                return false;
            }
        }

        return true;
    }
}
