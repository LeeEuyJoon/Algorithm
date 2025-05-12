import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // 같은 문자가 스택 top에 있으면 pop
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            // 아니면 push
            } else {
                stack.push(c);
            }
        }

        // 스택이 비어 있으면 전부 짝지어 제거 가능 → 1, 아니면 0
        return stack.isEmpty() ? 1 : 0;
    }
}
