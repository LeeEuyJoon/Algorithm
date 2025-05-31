import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length;
        
        // 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int maxDay = daysLeft[0];
        
        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) {
                count++;
            }
            else {
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}