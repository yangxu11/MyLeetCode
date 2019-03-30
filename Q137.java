package leetcode;

/**
 * 只出现一次的数字
 *
 * @author yx
 * @create 2019-03-30  11:51
 **/
public class Q137 {
    //位运算
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = (one & two);
            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }
}
