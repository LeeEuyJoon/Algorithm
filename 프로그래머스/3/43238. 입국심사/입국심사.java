import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        // n: 입국심사 기다리는 사람 수
        // times: 한 명을 심사하는 데 걸리는 시간
        
        // 비어있다고 무조건 넣는거 아님
        // n - time.length 번째 사람까지는 무조건 비어있는 심사관한테 보내고
        // 그 다음 사람부터는 .. 아 아닌가?

        // 음 ....
        // 사람마다 입국심사 끝나는 시간을 맵에 남겨야하나?
        // ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ
        
        // 이분 탐색
        // 0 (n이 0인 경우) -> min
        // 가장 일을 빨리 처리하는 심사관 한 명이 모든 사람 처리하는 데 걸리는 시간 -> max
        // 중간 값 검증하고 다음 루프 이런식으로
        // lo > hi 일때까지
        
        Arrays.sort(times);
        
        long lo = 0;
        long hi = (long) times[0] * n;
        long answer = 0;
        
        while (lo <= hi) {

            long mid = (lo + hi) / 2;

            long count = 0;
            for (long time : times) {
                count += mid / time;
                if (count >= n) break;
            }

            if (count >= n) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
        
    }
}