package leetcode.offer;

/**
 * 把字符串转换成整数
 *
 * @author yx
 * @create 2019-05-08  20:15
 **/
public class Q49 {
    public int StrToInt(String str) {
        if(str.length() == 0) return 0;
        int sign=1;
        if(str.startsWith("+")){
            sign=1;
            str = str.substring(1);
        } else if(str.startsWith("-")){
            sign=-1;
            str = str.substring(1);
        }
        long res = 0;
        for(int i=0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            if(c<'0' || c>'9') return 0;
            res = 10*res + c - '0';
            if(sign==1 && res > (long)Integer.MAX_VALUE) return 0;
            if(sign==-1 && -1*res < (long)Integer.MIN_VALUE) return 0;
        }

        return sign==1 ? (int)res : -1*(int)res;
    }
}
