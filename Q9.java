package leetcode;
//回文数
public class Q9 {
    //执行用时 : 104 ms, 在Palindrome Number的Java提交中击败了93.64% 的用户
    //内存消耗 : 40.5 MB, 在Palindrome Number的Java提交中击败了63.67% 的用户

    //只算一半的数，如果相等则true
    public boolean isPalindrome1(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        while(x>res){
            res = res*10 + x%10;
            x/=10;
        }
        return res==x || res/10 == x;
    }


    //暴力解法，从末尾加和，如果和原数字相等则为回文数
    public boolean isPalindrome2(int x) {
        if(x<0) return false;
        return x== getReverseNum(x);
    }
    public int getReverseNum(int x){
        int res = 0;
        while(x>0){
            res = res*10 + x%10;
            x/=10;
        }
        return res;
    }
}
