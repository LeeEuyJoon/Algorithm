import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        dp.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            // 이어붙인 수 (예: 55, 555, 5555)
            int concat = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(concat);

            // 가능한 조합 계산
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            // 목표 수 찾으면 조기 종료
            if (dp.get(i).contains(number)) return i;
        }

        return -1; // 8 이상이면 불가능
    }
}
