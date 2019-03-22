package leetcode;

import java.util.*;

public class Q332 {
    public static void main(String[] args) {//[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        String[][] s = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        Q332 q = new Q332();
        q.findItinerary(s);
    }
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK", flights, path);
        return path;
    }

    public void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, path);
        }
        path.addFirst(departure);
    }
}
