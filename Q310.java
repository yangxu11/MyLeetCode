package leetcode;

import java.util.*;

public class Q310 {
    //超时答案，广度优先搜索
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(edges.length==0) {
            for(int i=0 ; i<n ; i++) {
                result.add(i);
            }
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0 ; i<n ; i++) {
            int start = i;
            int[] known = new int[n];
            known[start]=1;

            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(start);
            int depth = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                for(int j=0 ; j<size ; j++) {
                    int now = queue.pop();
                    for(int[] edge : edges) {
                        if(edge[0]==now && known[edge[1]]!=1) {
                            queue.offer(edge[1]);
                            known[edge[1]]=1;
                        }
                        if(edge[1]==now && known[edge[0]]!=1) {
                            queue.offer(edge[0]);
                            known[edge[0]]=1;
                        }
                    }
                }

            }
            map.put(start,depth);
        }
        int min = Collections.min(map.values());
        for(int key : map.keySet()) {
            if(map.get(key)==min) {
                result.add(key);
            }
        }

        return result;

    }

    //从叶子节点开始删除，删除到不多于两个时，就是其最小树根节点（结果最多有两个值，否则无法成树）

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;



    }
}
