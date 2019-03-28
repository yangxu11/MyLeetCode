package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角II
 *
 * @author yx
 * @create 2019-03-28  19:52
 **/
public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0) return null;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        --rowIndex;
        while(rowIndex>=0){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int i=1 ; i<pre.size() ; i++){
                tmp.add(pre.get(i-1)+pre.get(i));
            }
            tmp.add(1);
            pre = tmp;
            --rowIndex;
        }
        return pre;
    }
}
