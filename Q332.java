package leetcode;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        stack.push("JFK");
        LinkedList<String> res = new LinkedList<>();
        while (!stack.isEmpty()) {
            String p = stack.peek();
            if (map.containsKey(p) && map.get(p).size() > 0) {
                stack.push(map.get(p).poll());
            } else {
                res.addFirst(stack.pop());
            }
        }
        return res;
    }
}
