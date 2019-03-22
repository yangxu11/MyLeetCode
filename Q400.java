package leetcode;

public class Q400 {
    public static void main(String[] args) {
        Q400 q = new Q400();
        long start = System.currentTimeMillis();
        System.out.println(q.findNthDigit(1000000000));
        System.out.println(System.currentTimeMillis()-start);
    }
    //5ms 70%
    //先找到数字的位数，和该位数的起始数字（注意要使用long,防止整型溢出）
    //然后n-total算出多出的位数，除以位数得到数字（注意是否能整除，如果能，数字-1），算出第几位
    public int findNthDigit(int n) {
        int i=1;
        long x = 9;
        long total = 0;
        //得到位数，和起始数字
        while(total<n){
            total = total + i*x;
            i++;
            x = x*10;
        }
        i--;
        x = x/10;
        //得到多出的位数
        total = n - (int)(total - i*x);
        x = x/9;
        int y = (int)total/i;
        int z = (int)total%i;

        if(z==0){//是否能整除，如果能， -1
            return ((int)x-1 + y)%10;
        } else {
            int num=(int)x+y;
            for(int j=0 ; j<i-z ; j++){
                num = num/10;
            }
            return num%10;
        }
    }
}
