import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 1. 각 작업의 배포 가능일 게산
        // 2. 배포 가능일 배열을 for문 돌려서 이전 값보다 작으면 count + 1
        
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length;
        int[] daysLeft = new int[n];
        
        for (int i = 0; i<n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int count = 0;
        int maxDay = daysLeft[0];
        
        for (int i=0; i<n; i++) {
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