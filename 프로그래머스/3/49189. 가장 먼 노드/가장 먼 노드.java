import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        // 1번으로부터 가장 멀리 떨어진 노드
        // bfs?
        
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i ++) graph.add(new ArrayList<>());
        
        for (int[] e: edge) {
            int a = e[0], b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // -1: 방문 전
        // 0: 시작 노드
        // 1~: 시작 노드로부터의 거리
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[1] = 0;
        q.add(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next: graph.get(cur)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++ ) {
            if (dist[i] > maxDist) maxDist = dist[i];
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) count++;
        }
        
        return count;
    }
}