import java.util.*;

// Solution 클래스에 static 멤버들은 모두 최상위 선언
class Solution {
    // 1) 상태 저장용 중첩 클래스
    private static class Info {
        int node, sheep, wolf;
        Set<Integer> visited;
        Info(int node, int sheep, int wolf, Set<Integer> visited) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visited = visited;
        }
    }

    // 2) 트리 인접 리스트
    private static List<Integer>[] tree;

    // 3) 트리 구축 메서드
    private static void buildTree(int[] info, int[][] edges) {
        int n = info.length;
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
        }
    }

    // 4) 실제 풀이 메서드
    public int solution(int[] info, int[][] edges) {
        buildTree(info, edges);
        int answer = 0;

        Deque<Info> queue = new ArrayDeque<>();
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while (!queue.isEmpty()) {
            Info now = queue.poll();
            answer = Math.max(answer, now.sheep);

            // 다음으로 탐색 가능한 노드 목록 구성
            Set<Integer> nextCandidates = new HashSet<>(now.visited);
            nextCandidates.addAll(tree[now.node]);

            for (int next : nextCandidates) {
                // 이미 방문 목록 복제
                Set<Integer> visitedCopy = new HashSet<>(nextCandidates);
                // 이 노드를 사용했으니 목록에서 제거
                visitedCopy.remove(next);

                if (info[next] == 1) { // 늑대
                    // 늑대가 양보다 많아지면 갈 수 없음
                    if (now.sheep > now.wolf + 1) {
                        queue.add(new Info(next, now.sheep, now.wolf + 1, visitedCopy));
                    }
                } else {             // 양
                    queue.add(new Info(next, now.sheep + 1, now.wolf, visitedCopy));
                }
            }
        }

        return answer;  
    }
}
