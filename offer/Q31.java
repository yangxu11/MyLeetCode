package leetcode.offer;

/**
 * 整数中1出现的次数
 *
 * @author yx
 * @create 2019-05-06  20:09
 **/
public class Q31 {
    //我们可以将一个数字拆分为最高位和其右边 ，比如3452，拆成3 和 452， 最高位high=3, last=452, 数的范围是几千的数字，那么power=1000
    //
    //先看最高位贡献了多少个1， 如果最高位大于1， 那么最高位贡献1000个1，1000~1999
    //
    //那么剩余位贡献多少个1呢，只要看0-999的个、十、百位贡献了多少个1， 那么 1000~1999，2000~2999， 的个、十、百位贡献的1的个数都是一样的 即high * countDigitOne(power-1)个1
    //
    //最后还剩下3000~3452 这last+1个数字的个、十、百位贡献的1的数量，即countDigitOne(last)
    //
    //全部加起来即可
    //
    //如果最高位等于1，那么最高位贡献last+1个1，只要看剩余位贡献多少个1：countDigOne(last) + countDitOne(power-1)
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0) return 0;
        if(n<10) return 1;
        int len = String.valueOf(n).length();
        int power = (int)Math.pow(10,len-1);
        int last = n%power;
        int high = n/power;
        if(high==1){
            return NumberOf1Between1AndN_Solution(last)+NumberOf1Between1AndN_Solution(power-1)+last+1;
        } else{
            return NumberOf1Between1AndN_Solution(last)+high*NumberOf1Between1AndN_Solution(power-1)+power;
        }
    }
}
