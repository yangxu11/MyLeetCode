package leetcode;

/**
 * Excel表列序号
 *
 * @author yx
 * @create 2019-04-03  19:37
 **/
public class Q171 {
    public int titleToNumber(String s) {
        if(s.length()==0) return 0;
        int sum=0;
        for(int i=0 ; i<s.length() ; i++){
            sum = sum*26 + s.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
