import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // 최단 거리 찾는 것과 유사한 느낌 -> bfs 접근
        // 단어의 첫 자리부터 words를 순회하면서 target과 일치하는 알파벳이 있는지 검토
        
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        
        q.offer(begin);
        dist.put(begin, 0);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            int curDist = dist.get(cur);
            
            if (cur.equals(target)) {
                return curDist;
            }
            for (String next: words) {
                if (!dist.containsKey(next) && canChange(cur, next)) {
                    dist.put(next, curDist + 1);
                    q.offer(next);
                }
            }
        }
        
        return 0;
    }
    
    // a, b가 알파벳 1개만 다른지 (교환 가능한지) 검사
    private boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}