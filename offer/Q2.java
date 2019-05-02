package leetcode.offer;

/**
 * 替换空格
 *
 * @author yx
 * @create 2019-05-02  11:19
 **/
public class Q2 {
    public String replaceSpace(StringBuffer str) {
        if(str.length()==0) return "";
        String s = "%20";
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == ' '){
                str.deleteCharAt(i);
                str.insert(i,s);
            }
        }
        return str.toString();
    }
}
