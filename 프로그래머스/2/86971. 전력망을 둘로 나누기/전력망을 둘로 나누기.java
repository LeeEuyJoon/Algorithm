import java.util.ArrayList;

class Solution {
    
    private static int N, answer;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    
    public int solution(int n, int[][] wires) {
        
        N = n;
        answer = n - 1;
        
        // 전선의 연결 정보를 저장할 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // 전선의 연결 정보를 인접 리스트에 저장
        for (int[] wire: wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        visited = new boolean[n + 1];
        dfs(1);
        return answer;
    }
    
    private static int dfs(int now) {
        visited[now] = true;
        
        // 자식 노드의 수를 저장하고 변환할 변수 선언
        int sum = 0;
        
        // 연결된 모든 전선 확인
        for (int next: adjList[now]) {
            if (!visited[next]) {
                int cnt = dfs(next); // 자식 트리가 가진 노드의 수
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                // 자식 노드의 수를 더함
                sum += cnt;
            }    
        }
        
        // 전체 자식 노드의 수에 1(현재 now 노드)을 더해서 반환
        return sum + 1;
    }
}