package leetcode;

public class Q7 {
    //执行用时 : 25 ms, 在Reverse Integer的Java提交中击败了89.56% 的用户
    //内存消耗 : 37.7 MB, 在Reverse Integer的Java提交中击败了22.28% 的用户

    //注意整数越界问题，转换为long类型
    public int reverse(int x) {
        long num = x;
        int sign = 1;
        if(num<0) sign = -1;
        num = Math.abs(num);
        long res=0;
        int flag=0;
        while(num>0){
            if(num%10>0){
                flag=1;
            }
            if(flag==1){
                res = res*10 + num%10;
            }
            num = num/10;
        }
        if(sign>0 && res>Integer.MAX_VALUE){
            return 0;
        } else if(sign<0 && res>Integer.MAX_VALUE-1){
            return 0;
        }
        return (int)(sign*res);
    }
}
