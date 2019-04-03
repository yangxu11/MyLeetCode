package leetcode;

import java.util.HashMap;
//分数转换为小数   int边界，转换成long
public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();
        //判断分子是否为0
        if (numerator == 0) {
            return "0";
        }

        //判断正负
        //result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        } else
            result.append("");

        Long num =  Math.abs((long) numerator);
        Long den = Math.abs((long) denominator);

        //整数部分
        result.append(num / den);
        num = num % den;
        if (num == 0) {
            return result.toString();
        }

        //确定小数部分
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());


        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;

            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else map.put(num, result.length());
        }
        return result.toString();
    }
}
