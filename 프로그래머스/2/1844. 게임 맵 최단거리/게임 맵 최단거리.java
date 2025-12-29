import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        
        // 최단거리 -> bfs 접근
        // 이동 할 수 있는 칸으로 이동하면서 count 증가
        // 도착하는 순간의 count 리턴
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        // dist[x][y] = (0, 0)에서 (x, y)까지의 지나간 칸 수
        int[][] dist = new int[n][m];
        
        // 시작점이 벽이면 바로 불가능
        if (maps[0][0] == 0) return -1;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            // 도착하면 즉시 리턴
            if (x == n - 1 && y == m - 1) {
                return dist[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크
                if (nx < 0 || nx >= n || ny < 0 || ny>= m) continue;
                
                // 벽이면 못 감
                if (maps[nx][ny] == 0) continue;
                
                // 이미 방문이면 스킵
                if (dist[nx][ny] != 0 ) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
                
            }
            
        }
        
        return -1;
        
    }
}
