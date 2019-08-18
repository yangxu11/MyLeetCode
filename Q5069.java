package leetcode;

/**
 * 按字典序排在最后的字符子串
 *
 * @author yx
 * @create 2019-08-18  16:55
 **/
public class Q5069 {

    //关键在于去除字符串连续相同字母的出现
    public String lastSubstring(String s) {

        int len = s.length();
        int index = 0;
        for(int i=1 ; i<len ; i++){
            if(s.charAt(i)==s.charAt(i-1)){
                while(i<len-1 && s.charAt(i)==s.charAt(i-1)){
                    i++;
                }
            }
            if(large(s,i,index)){
                index = i;
            }
        }

        return s.substring(index);
    }

    private boolean large(String s,int i,int j){
        int len = s.length();
        while(i<len && j<len){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j++;
            } else{
                return s.charAt(i)>s.charAt(j);
            }
        }

        return false;
    }
}
