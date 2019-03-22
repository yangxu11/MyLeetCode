package leetcode;
//实现strStr()
public class Q28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        for(int i=0 ; i<=haystack.length()-needle.length() ; i++){
            String str = haystack.substring(i);
            if(str.startsWith(needle)){
                return i;
            }
        }
        return -1;
    }
}
