package leetcode;
//丑数II
public class Q264 {
    public static void main(String[] args) {
        Q264 q = new Q264();
        System.out.println(q.nthUglyNumber(12));
    }
    //执行用时: 10 ms, 在Ugly Number II的Java提交中击败了71.49% 的用户
    //内存消耗: 25.6 MB, 在Ugly Number II的Java提交中击败了27.85% 的用户

    //创建数组存储丑数，数组中的每个数都会经历*2 *3 *5，用三个index来存储*2,*3,*5的进程
    //用三个数factor1,factor2,factor3来存储当前的还未*2 *3 *5的最小值，取其中最小来*2或3或5
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                factor2 = 2 * ugly[++index2];
            }
            if (factor3 == min) {
                factor3 = 3 * ugly[++index3];
            }
            if (factor5 == min) {
                factor5 = 5 * ugly[++index5];
            }
        }
        return ugly[n - 1];
    }
}
