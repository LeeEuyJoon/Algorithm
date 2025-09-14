import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선순위 배열을 내림차순 정렬해놓고
        // priorities 값 순회하면서 우선순위 값과 비교
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i : priorities) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;
                    
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}