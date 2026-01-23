import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        // level 1부터 계산해서 루프 돌린다?
        // 아니지 않을까? 너무 오래 걸릴 것 같은데
        
        // min level을 1, max level을 diff의 최대로 잡고 이진 탐색
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        
        // 루프 돌면서 계속 left right의 중간 값으로 검증하기
        // 루프 언제까지? left < right
        
        while(left < right) {
            int checkLv = (left + right) / 2;
            long time = 0;
            
            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                long timeCur = times[i];
                long timePrev = (i == 0) ? 0: times[i-1];
                
                if (checkLv >= diff) {
                    time += timeCur;
                }
                if (checkLv < diff) {
                    long fail = diff - (long) checkLv;
                    time += timeCur + fail * (timeCur + timePrev);
                }
            }
            
            if (time <= limit) right = checkLv;
            if (time > limit) left = checkLv + 1;
            
        }
        
        return left;
        
    }
}