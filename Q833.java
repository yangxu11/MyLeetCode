package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的查找与替换
 *
 * @author yx
 * @create 2019-08-10  15:49
 **/
public class Q833 {
    //注意indexes可能是乱序的，需要使用map来存储对应关系
    //然后从前向后遍历
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder res = new StringBuilder();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<indexes.length ; i++){
            map.put(indexes[i],i);
        }

        Arrays.sort(indexes);

        int cur = 0;

        for(int index : indexes){
            while(cur<index){
                res.append(S.charAt(cur));
                ++cur;
            }
            String s = sources[map.get(index)];
            if(S.startsWith(s,index)){
                res.append(targets[map.get(index)]);
                cur += s.length();
            }
        }
        res.append(S.substring(cur));

        return res.toString();
    }
}
