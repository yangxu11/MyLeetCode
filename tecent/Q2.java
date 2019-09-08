package leetcode.tecent;

/**
 * 2
 *
 * @author yx
 * @create 2019-09-01  20:52
 **/
public class Q2 {
    public static void main(String[] args) {
        Q2 q = new Q2();
        String[] words= {"aba","ab","abaaba"};
        System.out.println(q.getNum(words,"abaabaaba"));
    }

    public int getNum(String[] words,String str){
        int res = 0;
        for(String s : words){
            if(isValid(s,str)){
                ++res;
            }
        }
        return res;
    }


    public boolean isValid(String s,String str){
        if(s.length()>=str.length()){
            if(s.startsWith(str)){
                return true;
            } else{
                return false;
            }
        }
        if(!str.startsWith(s)) return false;
        int len = s.length();
        int index = len;
        while(index<str.length()){
            if(index+len>str.length()) break;
            String sub = str.substring(index,index+len);
            if(!s.equals(sub)){
                return false;
            }
            index += len;
        }

        return s.startsWith(str.substring(index));
    }
}
