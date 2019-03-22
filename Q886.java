package leetcode;

import java.util.*;
//可能的二分法 图着色问题
public class Q886 {
    Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int[] dis : dislikes) {
            //store the dislike relations in the ArrayList,which is the edges of the map
            if (!graph.containsKey(dis[0])) graph.put(dis[0], new ArrayList<>());
            graph.get(dis[0]).add(dis[1]);
            if (!graph.containsKey(dis[1])) graph.put(dis[1], new ArrayList<>());
            graph.get(dis[1]).add(dis[0]);
        }
        //the array used to store the colors of each vertex(0 for default, 1 for red, -1for blue)
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (graph.get(i) == null) continue;
            if (colors[i] == 0 && !paint(i, colors, 1))
                return false;
        }
        return true;
    }

    //return if it can successfully paint this vertex with color
    public boolean paint(int index, int[] colors, int color) {
        if (colors[index] != 0)
            return colors[index] == color;
        colors[index] = color;
        int length = graph.get(index).size();
        for (int i = 0; i < length; i++) {
            if (!paint(graph.get(index).get(i), colors, -1 * color))
                return false;
        }
        return true;
    }
}
