package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最小基因变化
 *
 * @author yx
 * @create 2019-05-17  19:28
 **/
public class Q433 {
    public int minMutation(String start, String end, String[] bank) {
        char[] genetic = {'A','C','G','T'};
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int len = 1;
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        for(String s : bank){
            wordSet.add(s);
        }
        beginSet.add(start);
        endSet.add(end);
        if(start.equals(end)) return 0;
        if(!wordSet.contains(end)) return -1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> s = beginSet;
                beginSet = endSet;
                endSet = s;
            }

            Set<String> tmp = new HashSet<>();
            for(String str : beginSet){
                char[] strs = str.toCharArray();
                for(int i=0 ; i<strs.length ; i++){
                    char old = strs[i];
                    for(char c : genetic){
                        strs[i] = c;
                        String s = String.valueOf(strs);
                        if(endSet.contains(s)) {
                            return len;
                        }
                        if(!visited.contains(s) && wordSet.contains(s)){
                            visited.add(s);
                            tmp.add(s);
                        }
                    }
                    strs[i] = old;
                }
            }
            beginSet=tmp;
            ++len;
        }
        return -1;
    }
}
