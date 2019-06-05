package leetcode;

/**
 * 最长特殊序列I
 *
 * @author yx
 * @create 2019-06-05  20:26
 **/
public class Q521 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        } else{
            return Math.max(a.length(),b.length());
        }
    }
}
