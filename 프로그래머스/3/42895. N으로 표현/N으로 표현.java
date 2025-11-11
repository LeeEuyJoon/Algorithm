import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N을 i번 사용했을 때 만들 수 있는 수의 집합
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // N을 i번 이어붙인 숫자 (예: 5, 55, 555)
            int repeated = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeated);

            // 이전 단계들의 조합으로 dp[i] 채우기
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int a : set1) {
                    for (int b : set2) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }

            // 이번 단계에서 number 찾으면 바로 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8번까지 못 찾으면 -1
        return -1;
    }
}