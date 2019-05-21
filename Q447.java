package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 *
 * @author yx
 * @create 2019-05-21  21:07
 **/
public class Q447 {
    //哈希表
    public int numberOfBoomerangs(int[][] points) {
        Map<Double,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0 ; i<points.length ; i++){
            for(int j=0 ; j<points.length ; j++){
                if(i!=j){
                    double dis = Math.pow(points[i][0]-points[j][0],2) +  Math.pow(points[i][1]-points[j][1],2) ;

                    if(!map.containsKey(dis)){
                        map.put(dis,1);
                    } else{
                        int n = map.get(dis);
                        res += 2*n;
                        map.put(dis,n+1);
                    }
                }
            }
            map.clear();//每轮清空map
        }
        return res;

    }
}
