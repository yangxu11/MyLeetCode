package leetcode;

import java.util.Arrays;
import java.util.List;
//钥匙与房间 （可略）
public class Q841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size()==0) return false;
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited,false);
        visit(rooms,0,visited);
        for(int i=0 ; i<rooms.size() ; i++) {
            if(visited[i]==false) return false;
        }
        return true;

    }
    public void visit(List<List<Integer>> rooms,int room,boolean[] visited) {
        //if(!visited.contains(false)) return;
        visited[room] = true;
        List<Integer> list = rooms.get(room);
        for(int i : list) {
            if(visited[i]==false) {
                visit(rooms,i,visited);
            }
        }
    }
}
