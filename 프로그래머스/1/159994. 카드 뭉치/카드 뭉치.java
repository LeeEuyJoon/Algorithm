import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        while (!goalDeque.isEmpty()) {
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                goalDeque.pollFirst();
                cardsDeque1.pollFirst();
            }
            else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                goalDeque.pollFirst();
                cardsDeque2.pollFirst();
            } else {
                break;
            }
        }
        
        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}