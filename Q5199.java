package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 交换字符串中的字符
 *
 * @author yx
 * @create 2019-09-22  12:05
 **/
public class Q5199 {

    //并查集+堆

    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] ch = s.toCharArray();
        int len = ch.length;

        parent = new int[len];

        for(int i=0 ; i<len ; i++){
            parent[i] = i;
        }

        for(List<Integer> pair : pairs){
            union(pair.get(0),pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for(int i=0 ; i<len ; i++){
            PriorityQueue<Character> pq = map.getOrDefault(find(i),new PriorityQueue<>());
            pq.offer(ch[i]);
            map.put(find(i),pq);
        }
        char[] res = new char[len];

        for(int i=0 ; i<len ; i++){
            res[i] = map.get(find(i)).poll();
        }

        return String.valueOf(res);
    }

    public int find(int root){
        int son = root;
        //向上寻找根
        while(root!=parent[root]){
            root = parent[root];
        }
        //路径压缩，将son直接挂到root下面，提升性能
        while(son!=root){
            int tmp = parent[son];
            parent[son] = root;
            son = tmp;
        }
        return root;
    }
    //将同一类别的东西聚合起来，挂到一个root下
    public void union(int a,int b){
        int aParent = find(a);
        int bParent = find(b);
        if(aParent != bParent){
            parent[aParent] = bParent;
        }
    }
}
