package leetcode;
//最后一个单词的长度
public class Q58 {
    //注意去掉首尾的空格，s.trim()
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        int index  = s.lastIndexOf(' ');
        if(index == -1){
            return s.length();
        } else{
            return s.length()-1- index;
        }
    }
}
