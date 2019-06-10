package leetcode;

/**
 * 学生出勤记录I
 *
 * @author yx
 * @create 2019-06-10  19:56
 **/
public class Q551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;

        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='A'){
                ++countA;
                countL=0;
            } else if(s.charAt(i)=='L'){
                ++countL;
                if(countL>2) return false;
            } else{
                countL=0;
            }
        }

        return countA<=1 ;
    }
}
