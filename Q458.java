package leetcode;

/**
 * 可怜地小猪
 *
 * @author yx
 * @create 2019-05-25  17:46
 **/
public class Q458 {

    //times为一只猪可能具有的生存状态，猪的数量相当于数据的维度，一只猪可以确定一个维度的值
    //根据猪的生存状态为桶编号
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest/minutesToDie + 1;
        int res = 0;
        int num = 1;
        while(num < buckets){
            num *= times;
            res++;
        }
        return res;
    }
}
