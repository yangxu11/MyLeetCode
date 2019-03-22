package leetcode;
//比特位计数
public class Q338 {
    //执行用时: 2 ms, 在Counting Bits的Java提交中击败了87.53% 的用户
    //内存消耗: 33.5 MB, 在Counting Bits的Java提交中击败了15.63% 的用户

    //找规律
    //n为<i的最大的2的幂级数，res[i] = res[i-n] + 1
    public int[] countBits(int num) {
        int[] res = new int[num+1];

        res[0] = 0;
        int x=1;

        for(int i=1 ; i<=num ; i++){
            if(x*2<=i){
                x = x*2;
            }
            res[i] = res[i-x] + 1;
        }
        return res;
    }
//位运算
    public int[] countBits2(int num) {
        int[] barr = new int[num + 1];
        barr[0] = 0;
        for (int i = 1; i <= num; i++) {
            barr[i] =  barr[i >> 1] +(i & 1);
        }
        return barr;
    }
}
