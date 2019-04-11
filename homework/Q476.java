package leetcode.homework;

public class Q476 {
    public int findComplement(int num) {
        if(num==0) return 1;
        int result=0;
        int x=1;
        while(num>0) {
            int remain = num%2;
            num = num/2;
            result = (1-remain)*x + result;
            x= x*2;
        }
        return result;
    }
}
