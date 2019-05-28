package leetcode;

/**
 * 汉明距离总和
 *
 * @author yx
 * @create 2019-05-28  20:00
 **/
public class Q477 {
    //计算每个数字每个位上0和1的个数，res += num(0) * num(1)
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int[] ones = new int[32];


        int len = nums.length;
        for(int i=0 ; i<nums.length ; i++){
            int num = nums[i];
            int index = 0;
            while(num>0){
                if((num&1) == 1){
                    ones[index] += 1;
                }
                num>>=1;
                index++;
            }
        }
        for(int one : ones){
            res += one*(len-one);
        }
        return res;
    }
}
