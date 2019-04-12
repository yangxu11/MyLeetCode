package leetcode;

/**
 * 各位数相加
 *
 * @author yx
 * @create 2019-04-12  17:39
 **/
public class Q258 {
    public int addDigits(int num) {
        if(num<10) return num;
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
