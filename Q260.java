package leetcode;

/**
 * 只出现一次的数II
 *
 * @author yx
 * @create 2019-04-12  19:13
 **/
public class Q260 {
    //将所有数异或后得到的结果为 xor = A^B
    //想将A,B分开，以xor中为1的位为切入点，因为在这个位上 A为1  B为0
    //则重新遍历数组，在该位上为1的与a异或，为0的与b异或，因为其他值都是重复的，异或值为0
    //所以最后分出的两个值就为结果
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for(int i : nums){
            xorResult ^= i;
        }
        int highestOneBit = Integer.toBinaryString(xorResult).length() - 1;
        int a = 0;
        int b = 0;
        for (int i : nums){
            if ((i >> highestOneBit & 1) == 0){
                a ^= i;
            }else {
                b ^= i;
            }
        }
        return new int[]{a,b};
    }
}
