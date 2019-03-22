package leetcode;
//加一
public class Q66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1 ; i>=0 ; i--){
            int num = digits[i]+carry;
            digits[i] = num%10;
            carry = num/10;
            if(carry==0) break;
        }
        if(carry==0) return digits;
        int[] res = new int[digits.length+1];
        res[0] = carry;
        for(int i=1 ; i<res.length ; i++){
            res[i] = digits[i-1];
        }
        return res;
    }
}
