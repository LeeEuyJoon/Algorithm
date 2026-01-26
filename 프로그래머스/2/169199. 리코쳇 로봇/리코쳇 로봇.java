import java.util.*;

class Solution {

    private char[][] map;
    private int rows;
    private int cols;

    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    public int solution(String[] board) {

        rows = board.length;
        cols = board[0].length();

        int sr = 0, sc = 0;

        // 맵 만들기 + 시작점 찾기
        map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[i].charAt(j);
                map[i][j] = c;
                if (c == 'R') { sr = i; sc = j; }
            }
        }

        // dist: 각 노드까지 얼마나 걸리는지
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            // 목표에 도착하면 반환
            if (map[r][c] == 'G') return dist[r][c];

            for (int d = 0; d < 4; d++) {
                // 슬라이드
                int[] next = slide(r, c, d);
                // nr, nc 업데이트
                int nr = next[0], nc = next[1];

                // 움직이지 못했으면 스킵
                if (nr == r && nc == c) continue;

                if (dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }

    private int[] slide(int r, int c, int d) {
        int nr = r, nc = c;

        while (true) {
            int tr = nr + dr[d];
            int tc = nc + dc[d];

            // 다음 칸이 밖이거나 장애물이면 현재 위치에서 멈춤
            if (tr < 0 || tr >= rows || tc < 0 || tc >= cols) break;
            if (map[tr][tc] == 'D') break;

            nr = tr;
            nc = tc;
        }

        return new int[]{nr, nc};
    }
}
