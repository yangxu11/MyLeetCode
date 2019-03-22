package leetcode;

import java.util.ArrayList;
import java.util.List;

//自除数
public class Q728 {
    //8ms 48%
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left ; i<=right ; i++){
            int flag=0;
            int num = i;
            while(num>0){
                int x = num%10;
                if(x==0 || i%x!=0) {
                    flag=1;
                    break;
                }
                num = num/10;
            }
            if(flag==0){
                result.add(i);
            }
        }
        return result;
    }
}
