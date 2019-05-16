package leetcode;

/**
 * 数字转16进制
 *
 * @author yx
 * @create 2019-05-16  17:37
 **/
public class Q405 {
    //位运算
    public String toHex(int num) {
        if(num==0) return "0";
        String hex = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();

        while(num!=0 && sb.length()<8){
            sb.append(hex.charAt(num & 0xf));
            num>>=4;
        }

        return sb.reverse().toString();
    }
}
