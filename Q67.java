package leetcode;
//二进制加法
public class Q67 {
    //注意这种编程手法，更简洁
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int i=str1.length-1 , j = str2.length-1;
        int carry = 0;

        while(i>=0 || j>=0){
            int x = (i>=0) ? str1[i]-'0' : 0;
            int y = (j>=0) ? str2[j]-'0' : 0;
            int num = x+y+carry;
            res.insert(0,num%2);
            carry = num/2;
            i--;j--;
        }
        if(carry==1) res.insert(0,'1');
        return res.toString();
    }
}
