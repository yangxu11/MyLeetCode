package leetcode;
//复数乘法
public class Q537 {
    //7ms 61%
    public String complexNumberMultiply(String a, String b) {
        String[] stra = a.split("\\+");
        String[] strb = b.split("\\+");
        int a1 = Integer.parseInt(stra[0]);
        int b1 = Integer.parseInt(strb[0]);
        int a2 = Integer.parseInt(stra[1].substring(0,stra[1].length()-1));
        int b2 = Integer.parseInt(strb[1].substring(0,strb[1].length()-1));
        int x = a1*b1 - a2*b2;
        int y = a1*b2 + a2*b1;
        return x + "+" + y +"i";
    }
}
