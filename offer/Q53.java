package leetcode.offer;

/**
 * 表示数值的字符串
 *
 * @author yx
 * @create 2019-05-12  12:00
 **/
public class Q53 {
    public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
