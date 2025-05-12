import java.util.ArrayDeque;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        // 괄호 매핑 테이블
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        // 회전을 위해 문자열을 두 배로
        String doubled = s + s;
        int answer = 0;

        // 각 회전마다 검사
        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // i부터 i+n-1까지 substring 순회
            for (int j = i; j < i + n; j++) {
                char c = doubled.charAt(j);
                if (!map.containsKey(c)) {
                    // 여는 괄호면 스택에 push
                    stack.push(c);
                } else {
                    // 닫는 괄호일 때 스택 비었거나 매핑이 다르면 해당 회전 건너뛰기
                    if (stack.isEmpty() || stack.pop() != map.get(c)) {
                        continue A;
                    }
                }
            }

            // 한 회전이 모두 유효하면 정답++
            if (stack.isEmpty()) {
                answer++;
            }
        }

        // 메서드 블록 내에서 return
        return answer;
    }
}
