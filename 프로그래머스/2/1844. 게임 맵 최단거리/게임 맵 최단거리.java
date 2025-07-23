import java.util.ArrayDeque;

class Solution {

    // 이동할 수 있는 방향 (상하좌우)
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] maps) {
        // 맵 크기
        int N = maps.length;
        int M = maps[0].length;

        // 최단 거리 저장 배열
        int[][] dist = new int[N][M];

        // BFS 큐
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 시작점 세팅
        queue.addLast(new Node(0, 0));
        dist[0][0] = 1;

        // BFS
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 맵 밖이면 패스
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                // 벽이면 패스
                if (maps[nr][nc] == 0) continue;
                // 처음 방문이면 거리 갱신 후 큐에 추가
                if (dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(nr, nc));
                }
            }
        }
        
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
}
