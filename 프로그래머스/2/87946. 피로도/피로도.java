class Solution {
    
    private static int answer;
    private static boolean[] visited;
    private static int[][] Dungeons;

    
    // 순회하면서 최소 피로도 이하로 k 가 떨어지면 continue
    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        // dfs 하면 되지 않을까??
        
        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        backtrack(k, 0);
        
        return answer;
        
    }
}