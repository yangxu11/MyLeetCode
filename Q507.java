package leetcode;
//完美数
public class Q507 {
    //9ms  90%
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        int result=1;
        for(int i=2 ; i<=(int)Math.sqrt(num) ; i++){
            if(num%i==0){
                result += (i + num/i);
            }
        }
        return result==num;
    }
}
