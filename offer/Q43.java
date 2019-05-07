package leetcode.offer;

/**
 * 左旋转字符串
 *
 * @author yx
 * @create 2019-05-07  20:21
 **/
public class Q43 {
    public String LeftRotateString(String str,int n) {
        if(str.length() <= 1) return str;
        n = n%str.length();
        return str.substring(n) + str.substring(0,n);
    }
}
