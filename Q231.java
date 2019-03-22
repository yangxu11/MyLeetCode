package leetcode;

public class Q231 {
    //23%
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;

        String str = Integer.toBinaryString(n);
        str = str.substring(1);
        if(str.contains("1")) return false;

        return true;
    }
    //65%  按位与运算
    public boolean isPowerOfTwo2(int n) {
        if(n<=0) return false;
        if((n&n-1)==0) return true;
        return false;
    }
}
