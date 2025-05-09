import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 스테이지별 도전자 수 구하기
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }
        
        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) { // 도전한 사람이 없다면 실패율은 0
                fails.put(i, 0.);
            }
            else {
                fails.put(i, challenger[i] / total); // 실패율 구하기
                total -= challenger[i]; // 다음 스테이지 도전자 인원 업데이트
            }
        }
        
        // 실패율이 높은 스테이지부터 내림차순 정렬
        return fails.entrySet().stream().sorted((o1, o2) -> 
        o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(),
        o2.getKey()) : Double.compare(o2.getValue(),
        o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
    }
}