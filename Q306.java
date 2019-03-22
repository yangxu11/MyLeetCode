package leetcode;
//累加数
public class Q306 {
    //执行用时 : 3 ms, 在Additive Number的Java提交中击败了57.14% 的用户
    //内存消耗 : 33.3 MB, 在Additive Number的Java提交中击败了0.00% 的用户

    //双重遍历，以第一个数，第二个数的长度来遍历，计算接下来的是否成立
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) {//不能有0开头的数字除了0
            return false;
        }
        if (num.charAt(i) == '0' && j > 1) {
            return false;
        }
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));//防止整数溢出
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;//x1 == pre(x2)
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
