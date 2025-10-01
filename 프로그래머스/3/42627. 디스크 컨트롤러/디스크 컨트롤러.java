import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. Job 리스트로 변환
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(new Job(i, jobs[i][0], jobs[i][1]));
        }

        // 2. 요청 시각 기준 정렬
        list.sort(Comparator.comparingInt(j -> j.start));

        // 3. PQ (우선순위: length -> start -> id)
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.length != b.length) return a.length - b.length;
                if (a.start != b.start) return a.start - b.start;
                return a.id - b.id;
            }
        );

        int time = 0;      // 현재 시각
        int index = 0;     // 아직 PQ에 안 넣은 작업 인덱스
        int total = 0;     // 반환 시간 합계
        int count = 0;     // 완료된 작업 수

        while (count < jobs.length) {
            // 현재 시간까지 도착한 작업 PQ에 삽입
            while (index < list.size() && list.get(index).start <= time) {
                pq.add(list.get(index++));
            }

            if (pq.isEmpty()) {
                // 대기큐가 비었으면 시간 점프
                time = list.get(index).start;
            } else {
                // PQ에서 꺼내 실행
                Job cur = pq.poll();
                time += cur.length;
                total += time - cur.start;
                count++;
            }
        }

        return total / jobs.length;
    }
}

class Job {
    int id;
    int start;
    int length;
    Job(int id, int start, int length) {
        this.id = id;
        this.start = start;
        this.length = length;
    }
}
