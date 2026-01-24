import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        // 청소 시간 포함 겹치는 구간의 최대 겹침 수가 답
        
        int n = book_time.length;
        
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = toMin(book_time[i][0]);
            times[i][1] = toMin(book_time[i][1]) + 10;
        }
        
        Arrays.sort(times, (a, b) -> {
                   if (a[0] != b[0]) return a[0] - b[0];
                   return a[1] - b[1];
                   });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int maxRooms = 0;
        
        for (int[] t: times) {
            int start = t[0];
            int available = t[1];
            
            // 가장 빨리 비는 방이 start 이전이면 재사용
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            // 아니면 방 새로 파기
            pq.offer(available);
            maxRooms = Math.max(maxRooms, pq.size());
        }
        
        return maxRooms;
        
    }
    
    private int toMin(String hhmm) {
        String[] parts = hhmm.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}