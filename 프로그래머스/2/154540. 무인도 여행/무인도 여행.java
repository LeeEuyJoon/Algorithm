import java.util.*;

class Solution {

    // dfs에서 다음 노드 가는 방향
    private static final int[][] direction = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private int rows;
    private int cols;
    private Character[][] map;

    public int[] solution(String[] maps) {

        // dfs?
        // maps는 전부 2차원 배열로 바꾸고
        // 타일을 돌면서 방문했으면 그 섬 합 업데이트하고 방문한 노드 O으로 바꾸기

        // maps -> Character[][]
        rows = maps.length;
        cols = maps[0].length();

        map = new Character[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        // (0,0) 부터 dfs로 노드 돌기 (노드가 x면 안 돌고 패스)
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] != 'X') {
                    int sum = dfs(i, j);
                    result.add(sum);
                }
            }
        }

        if (result.isEmpty()) return new int[]{-1};
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int r, int c) {

        // 현재 식량 값
        int sum = map[r][c] - '0';

        // 방문 처리
        map[r][c] = 'X';

        // 네 방향 탐색
        for (int[] d : direction) {
            int nr = r + d[0];
            int nc = c + d[1];

            // 범위 밖이면 패스
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            // X 패스
            if (map[nr][nc] == 'X') continue;

            // 같은 섬의 남은 땅 재귀로 더하기
            sum += dfs(nr, nc);
        }

        return sum;
    }
}
