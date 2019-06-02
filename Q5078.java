package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 负二进制数相加
 *
 * @author yx
 * @create 2019-06-02  11:38
 **/
public class Q5078 {
    //重点是进位的表示
    //比如0位都是1，相加和为2，负进制表示为110，说明需要向高位和高高位进位1
    //为了避免对高高位有影响，如果都是1，则进位-1，如果高位无法满足1，则向高高位进位1，并且高位为1
    //相当于如果高位和大于1 进位表示为 -1 如果<1 表示为1 1
    //再对进位的值正确解析就行
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int c = 0;

        List<Integer> list = new ArrayList<>();

        while(len1>0 || len2>0){
            int x1 = len1<=0 ? 0 : arr1[len1-1];
            int x2 = len2<=0 ? 0 : arr2[len2-1];

            int tmp = x1+x2+c;
            if(tmp==0 || tmp==1){//不进位
                list.add(tmp);
                c = 0;
            } else if(tmp==3){
                list.add(1);
                c = -1;
            } else if(tmp == -1){//高位和<1
                list.add(1);
                c = 1;
            } else if(tmp==2){
                list.add(0);
                c = -1;
            }
            --len1;
            --len2;
        }
        if(c==1){
            list.add(1);
        } else if(c==-1){
            list.add(1);
            list.add(1);
        }
        Collections.reverse(list);
        int index = list.indexOf(1);
        if(index==-1){
            return new int[]{0};
        } else{
            int[] res = new int[list.size()-index];
            for(int i=0 ; i<res.length ; i++){
                res[i] = list.get(i+index);
            }
            return res;
        }
    }
}
