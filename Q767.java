package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//重构字符串
public class Q767 {
    //60%  建立一个堆，每次拿出剩余的最多的两个字母加入字符串，然后将次数-1放回堆中，如果次数为0，则舍弃
    // 如果最后剩下的长度超过1，返回""
    public String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0 ; i<S.length() ; i++) {
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        }
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]<b[1] ? 1 : (a[1]==b[1] ? 0 : -1);
            }

        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        for(char c : map.keySet()){
            int x = (int)(c);
            int[] a = new int[]{x,map.get(c)};
            pq.add(a);
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>=2){
            int[] a = pq.poll();
            int[] b = pq.poll();
            sb.append((char)a[0]);
            sb.append((char)b[0]);
            a[1] = a[1] - 1;
            if(a[1]!=0) {
                pq.add(a);
            }
            b[1] = b[1] - 1;
            if(b[1]!=0) {
                pq.add(b);
            }
        }
        int[] a = pq.poll();
        if(a!=null) {
            if(a[1]>1) {
                return "";
            }
            sb.append((char)a[0]);
        }
        return sb.toString();
    }
}
