package leetcode;

import java.util.*;

//K 站中转内最便宜的航班
public class Q787 {
    //执行用时: 12 ms, 在Cheapest Flights Within K Stops的Java提交中击败了85.59% 的用户
    //内存消耗: 51.5 MB, 在Cheapest Flights Within K Stops的Java提交中击败了0.00% 的用户

    //广度优先搜索
    //建立dp存储上一次飞行所能到达的城市的最少的钱
    //第K次时，遍历航班，如果起点为上一次能到达的城市，则在上次基础上加上本次票价，找到多个航班到达同一目的地的最小值
    //每次dp[dst]有值时，取其最小
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int[] e : flights){
            if(e[0] == src){
                dp[e[1]] = e[2];
            }
        }
        int min = dp[dst];

        for(int i=0 ; i<K ; i++){
            int[] dp1 = new int[n];
            Arrays.fill(dp1,Integer.MAX_VALUE);
            for(int[] f : flights){
                if(dp[f[0]] != Integer.MAX_VALUE){
                    dp1[f[1]] = Math.min(dp[f[0]]+f[2],dp1[f[1]]);
                }
            }
            dp = dp1;
            if(dp[dst]!=Integer.MAX_VALUE) min = Math.min(dp[dst],min);
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];

        Arrays.fill(cost,-1);
        Map<Integer,List<int[]>> map = new HashMap<>();

        for(int[] f : flights){
            List<int[]> list = map.getOrDefault(f[0],new ArrayList<>());
            list.add(new int[]{f[1],f[2]});
            map.put(f[0],list);
        }

        cost[src] = 0;
        boolean[] visited = new boolean[n];
        Set<Integer> cur = new HashSet<>();
        cur.add(src);

        while(K>=0){
            Set<Integer> temp = new HashSet<>();
            int[] copy = Arrays.copyOf(cost,n);
            for(int x : cur){
                List<int[]> list = map.get(x);
                if(list==null || list.isEmpty()) continue;
                for(int[] f : list){
                    if(cost[f[0]]==-1){
                        copy[f[0]] = cost[x]+f[1];
                    } else{
                        copy[f[0]] = Math.min(copy[f[0]],cost[x]+f[1]);
                    }
                    temp.add(f[0]);
                }
            }
            K--;
            cur = temp;
            cost = copy;
        }

        return cost[dst];
    }
}
