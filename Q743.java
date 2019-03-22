package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
//网络延迟问题，最短路径算法，Dijkstra算法的实现
//需要一个 dist[]存储距离  known[]存储是否访问过  pre[]存储上一个节点  pq堆来存储未访问节点的最小值
public class Q743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K - 1] = 0;
        int[] known = new int[N];
        pq.add(dist[K - 1]);

        int pre[] = new int[N];
        pre[K-1] = K;

        while (!pq.isEmpty()) {
            int dis = pq.poll();
            int index = -1;
            for (int i = 0; i < N; i++) {
                if (dist[i] == dis && known[i] == 0) {
                    index = i;
                }
            }
            if (index == -1) continue;
            known[index] = 1;
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == index + 1) {
                    if (known[times[i][1] - 1] == 0) {
                        if (times[i][2] + dis < dist[times[i][1] - 1]) {
                            pq.remove(dist[times[i][1] - 1]);
                            dist[times[i][1] - 1] = times[i][2] + dis;
                            pre[times[i][1] - 1] = index+1;
                            pq.add(dist[times[i][1] - 1]);
                        }
                    }
                }
            }
        }

        Arrays.sort(dist);
        if (dist[N - 1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[N - 1];
        }
    }
}
