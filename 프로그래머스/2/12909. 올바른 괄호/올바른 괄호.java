import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        
        // 첫 문자가 "("인지 ")"인지 검사
        // 마지막 문자가 "("인지 ")"인지 검사
        // 각 문자를 for문 돌면서 "(" 이거면 push ")" 이거면 pop
        // size가 0이면 트루
        
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return false;
 
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(0);
            else if (c == ')') {
                if (stack.isEmpty()) { return false; }
                stack.pop();
            }
        }
        
        return stack.size() == 0 ? true : false;
        
    }

}