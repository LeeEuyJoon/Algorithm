import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited);
        
        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    void dfs(String current, String numbers, boolean[] visited) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current)); // 조합을 숫자로 저장
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
