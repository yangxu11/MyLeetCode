package leetcode;

/**
 * 找不同
 *
 * @author yx
 * @create 2019-04-30  17:11
 **/
public class Q389 {
    //位运算
    public char findTheDifference(String s, String t) {
        int common = 0;
        for(int i=0 ; i<s.length() ; i++){
            common ^= (int)s.charAt(i);
        }
        for(int i=0 ; i<t.length() ; i++){
            common ^= (int)t.charAt(i);
        }
        return (char)common;
    }
}
