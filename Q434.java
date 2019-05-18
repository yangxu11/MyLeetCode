package leetcode;
//字符串中的单词数
public class Q434 {

    public int countSegments(String s) {
        String str = s.trim();
        if(str.length()==0) return 0;
        String[] strs = str.split(" ");
        int count =0;
        for(String i : strs){
            if(i.trim().length()!=0){
                ++count;
            }
        }
        return count;
    }
}
