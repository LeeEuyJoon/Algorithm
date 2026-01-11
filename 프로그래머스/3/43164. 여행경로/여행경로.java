import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }

        dfs("ICN");

        return route.toArray(new String[0]);
    }
    
    private void dfs(String cur) {
        PriorityQueue<String> pq = graph.get(cur);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        
        route.addFirst(cur);
    }
}