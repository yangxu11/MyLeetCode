package leetcode;
//最长公共前缀
public class Q14 {
    //遍历
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        String res = "";
        for(int i=0 ; i<strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(i==s.length() || s.charAt(i)!=c){
                    return res;
                }
            }
            res += c;
        }
        return res;
    }
}
