package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 *
 * @author yx
 * @create 2019-04-03  20:22
 **/
public class Q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet();
        for(int i=0 ; i<=s.length()-10 ; i++){
            String str = s.substring(i,i+10);
            if(!set.add(str) && !res.contains(str)){
                res.add(str);
            }
        }
        return res;
    }
}
