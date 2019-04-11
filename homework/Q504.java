package leetcode.homework;
//七进制
public class Q504 {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        if(num<0) sb.append("-");
        num = Math.abs(num);
        int div = 1;
        int i=1;
        for(; i<=num ; i=i*7){}
        i=i/7;
        while(i>0) {
            int x = num/i;
            sb.append(String.valueOf(x));
            num = num%i;
            i=i/7;
        }
        return sb.toString();
    }
}
