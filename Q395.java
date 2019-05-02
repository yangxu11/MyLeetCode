package leetcode;

/**
 * 至少有K个字符的最长子串
 *
 * @author yx
 * @create 2019-05-02  10:20
 **/
public class Q395 {

    //先用个数不满足K个的字母分割字符串，递归
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        if(k<=1) return s.length();
        int[] nums = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            nums[s.charAt(i)-'a'] += 1;
        }
        int index = -1;
        for(int i=0 ; i<26 ; i++){
            if(nums[i]>0 && nums[i]<k){
                index = i;
                break;
            }
        }
        if(index == -1) return s.length();
        String[] strs = s.split(String.valueOf((char)(index+'a')));

        int res = 0;

        for(int i=0 ; i<strs.length ; i++){
            res = Math.max(longestSubstring(strs[i],k),res);
        }
        return res;
    }
}
