class Solution {
    private static int[][] computer;
    private static boolean[] visited;
    
    private static void dfs(int n) {
        visited[n] = true;
        for (int i = 0; i < computer[n].length; i++) {
            if (computer[n][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }       
    }   
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}