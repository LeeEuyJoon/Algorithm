import java.util.Arrays;

class Solution {
    private static int[] parent;
    
    private static int find(int x) {
        // x가 속한 집합의 루트 노드 찾기
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        // 두 집합을 하나의 집합으로 합치기
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        // 비용을 기준으로 다리를 오름차순 설정
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // parent 배열 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for (int[] edge: costs) {
            if (edges == n - 1)
                break;
            
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        
        return answer;
    }
}