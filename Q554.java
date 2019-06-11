package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//砖墙
public class Q554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();

        for(List<Integer> list : wall){
            int sum = 0;
            for(int i=0 ; i<list.size()-1 ; i++){
                sum+=list.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for(int num : map.keySet()){
            res = Math.max(res,map.get(num));
        }

        return wall.size()-res;
    }
}
