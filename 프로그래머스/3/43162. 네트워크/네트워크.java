class Solution {
    private static boolean[] visit;
    private static int[][] computer;
    
    private static void dfs(int now) {
        visit[now] = true; // 현재 노드 방문 처리
        for (int i = 0; i < computer[now].length; i++) {
            // 연결되어 있으며 방문하지 않은 노드라면
            if (computer[now][i] == 1 && !visit[i]) {
                dfs(i); // 해당 노드를 방문하러 이동
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visit = new boolean[n]; // 방문 여부
        
        for (int i=0; i < n; i++) {
            if (!visit[i]) { // 아직 방문하지 않은 노드라면 해당 노드를 시작으로 dfs 진행
                dfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
}