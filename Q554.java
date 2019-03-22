package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//砖墙
public class Q554 {
    public int leastBricks(List<List<Integer>> wall) {
        int length = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<wall.size() ; i++) {
            List<Integer> list = wall.get(i);
            List<Integer> lens = new ArrayList<>();
            int len = 0;
            for(int j=0 ; j<list.size() ;j++) {
                len = len +list.get(j);
                lens.add(len);
            }
            length = len;
            for(int num : lens) {
                if(map.containsKey(num)) {
                    map.put(num,map.get(num)+1);
                } else {
                    map.put(num,1);
                }
            }
        }
        map.remove(length);
        if(map.isEmpty()) return wall.size();
        return wall.size()- Collections.max(map.values());

    }
}
