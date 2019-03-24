package leetcode;
//子串能表示从 1 到 N 数字的二进制串
public class Q1023 {

    public boolean queryString1(String S, int N) {
        for(int x = N; x > 0; --x){
            if(S.indexOf(Integer.toBinaryString(x)) == -1){
                return false;
            }
        }
        return true;
    }


    public boolean queryString2(String S, int N) {
        for(int i=1 ; i<=N ; i++){
            if(!S.contains(toBinary(i))) return false;
        }
        return true;
    }
    public String toBinary(int n){
        String res = "";
        while(n>0){
            res = n%2 + res;
            n = n/2;
        }
        return res;
    }
}
