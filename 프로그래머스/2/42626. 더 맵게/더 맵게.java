import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i: scoville) {
            pq.add(i);
        }
        
        int answer = 0;
        
        while (pq.peek() != null && pq.peek() < K) {
            Integer n1 = pq.poll();
            Integer n2 = pq.poll();
            
            if (n1 == null || n2 == null) return -1;
            
            int new_num = n1 + n2 * 2;
            pq.add(new_num);
            
            answer++;
        }
        
        return answer;
    }
}