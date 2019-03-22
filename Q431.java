package leetcode;
//等差数列划分
public class Q431 {
    //执行用时: 1 ms, 在Arithmetic Slices的Java提交中击败了100.00% 的用户
    //内存消耗: 25.9 MB, 在Arithmetic Slices的Java提交中击败了16.67% 的用户

    //等差数列长度n每增加1，数量增加n-2
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<=2) return 0;
        int result = 0;
        int count = 2;
        int pre = A[1]-A[0];

        for(int i=2 ; i<A.length ; i++){
            if(A[i] - A[i-1] == pre){
                count++;
                result += count-2;
            } else {
                count = 2;
                pre = A[i] - A[i-1];
            }
        }
        return result;
    }
}
