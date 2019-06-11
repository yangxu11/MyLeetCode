package leetcode;

/**
 * 反转字符串中的单词III
 *
 * @author yx
 * @create 2019-06-11  20:12
 **/
public class Q557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String[] strs = sb.toString().split(" ");
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.insert(0,str+" ");
        }
        return res.toString().trim();
    }
}
