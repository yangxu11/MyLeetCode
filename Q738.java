package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//单调递增的数字 93%  主要前后数字的重复，如果后一个比前一个小要回退1+same位，再-1 ，加9补位
public class Q738 {
    public static void main(String[] args) {
        Q738 q = new Q738();
        System.out.println(q.monotoneIncreasingDigits(1234));
    }
    public int monotoneIncreasingDigits(int N) {
        List<Integer> num = new ArrayList<>();
        while(N>0) {
            num.add(N%10);
            N = N/10;
        }
        Collections.reverse(num);
        int result=0;
        int index = 0;
        int same = 0;
        int i=1;
        for(; i<num.size() ; i++) {
            if(num.get(i)<num.get(i-1)){
                index=i-1-same;
                break;
            } else if(num.get(i)==num.get(i-1)){
                same++;
            } else {
                same=0;
            }
            result = result*10 + num.get(i-1);
        }
        if(i == num.size()-1 && index==0) {
            return result*10+num.get(num.size()-1);
        } else {
            for(int j=0 ; j<same ; j++) {
                result = result/10;
            }
            result = result*10 + num.get(index)-1;
            for(int j=index+1 ; j<num.size() ; j++) {
                result = result*10 + 9;
            }
            return result;
        }

    }
}
