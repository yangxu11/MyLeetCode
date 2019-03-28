package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author yx
 * @create 2019-03-28  19:49
 **/
public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);
        --numRows;
        while(numRows>0){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int i=1 ; i<pre.size() ; i++){
                tmp.add(pre.get(i-1)+pre.get(i));
            }
            tmp.add(1);
            res.add(tmp);
            pre = tmp;
            --numRows;
        }
        return res;
    }
}
