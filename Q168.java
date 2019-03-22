package leetcode;
//Excel表列名称
public class Q168 {
    //10进制转26进制
    public String convertToTitle(int n) {
        if(n==0) return "";
        StringBuilder sb = new StringBuilder();
        while(n>0){
            n--;
            int c = n % 26;
            sb.insert(0, (char) (c + 'A'));
            n = n / 26;
        }
        return sb.toString();
    }
}
