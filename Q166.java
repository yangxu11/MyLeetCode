package leetcode;

import java.util.HashMap;
import java.util.Map;
//分数转换为小数   int边界，转换成long
public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long,Integer> map = new HashMap<>();
        int sign=0;
        if((numerator>0&&denominator>0)||(numerator<0&&denominator<0)) {
            sign=0;
        }
        if((numerator>0&&denominator<0)||(numerator<0&&denominator>0))
        {
            sign = 1;
        }
        long x = Math.abs((long)numerator);
        long y = Math.abs((long)denominator);
        sb.append(String.valueOf(x/y));
        x = x%y;
        if(x == 0){
            if(sign==1) {
                return "-"+sb.toString();
            } else {
                return sb.toString();
            }
        }
        sb.append(".");

        int index = sb.length();
        map.put(x,index);
        x =x*10;
        while(true) {
            long quot = x/y;
            sb.append(String.valueOf(quot));
            long remainer = x%y;
            if(remainer==0) break;
            if(map.containsKey(remainer)) {
                int start = map.get(remainer);
                String sameStr = sb.substring(start);
                String diffStr = sb.substring(0,start);
                if(sign==1) {
                    return "-"+diffStr+"(" + sameStr +")";
                } else {
                    return diffStr+"(" + sameStr +")";
                }

            } else {
                map.put(remainer,++index);
            }
            x = remainer*10;
        }

        if(sign==1) {
            return "-"+sb.toString();
        } else {
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Q166 q = new Q166();
        System.out.println(q.fractionToDecimal(-2147483648,1));
    }
}
