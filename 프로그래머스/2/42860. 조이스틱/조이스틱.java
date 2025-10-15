class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 기본 이동 (모두 오른쪽으로)

        // 알파벳 상하 이동
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // A 연속 구간 고려한 좌우 이동
            int next = i + 1; // A가 끝나는 위치
            while (next < len && name.charAt(next) == 'A') // i=0 next=1 -> charAt(1) -> A ... next = 4
                next++;

            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }

        answer += move;
        return answer;
    }
}
