package leetcode;
//字符串中的单词数
public class Q434 {
    //注意连续的空格，和结尾处的空格
    public int countSegments(String s) {
        if(s.length()==0) return 0;
        int sign=0;
        int count=0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c==' '){
                if(sign==1){
                    count++;
                    sign=0;
                }
            } else {
                sign=1;
            }
        }
        return s.charAt(s.length()-1)==' ' ? count : count+1;
    }
}
