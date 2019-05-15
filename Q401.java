package leetcode;

import java.util.ArrayList;
import java.util.List;
//二进制手表

public class Q401 {
    //执行用时: 3 ms, 在Binary Watch的Java提交中击败了76.46% 的用户
    //内存消耗: 34.8 MB, 在Binary Watch的Java提交中击败了4.25% 的用户

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int i=0 ; i<12 ; i++){
            for(int j=0 ; j<60 ; j++){
                if(count(i)+count(j) == num){
                    String str = i+":";
                    str += j<10 ? "0"+j : j;
                    res.add(str);
                }
            }
        }
        return res;
    }
    private int count(int x){
        int count =0;
        while(x>0){
            if((x&1)==1){
                ++count;
            }
            x>>=1;
        }
        return count;
    }
}
