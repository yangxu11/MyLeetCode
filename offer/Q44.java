package leetcode.offer;

/**
 * 反转单词顺序序列
 *
 * @author yx
 * @create 2019-05-08  17:23
 **/
public class Q44 {
    public String ReverseSentence(String str) {
        if(str==null || str.trim().equals("")) return str;
        String[] strs = str.trim().split(" ");
        String res = "";
        for(int i=strs.length-1 ; i>=0 ; i--){
            res += strs[i]+" ";
        }
        return res.trim();
    }
}
