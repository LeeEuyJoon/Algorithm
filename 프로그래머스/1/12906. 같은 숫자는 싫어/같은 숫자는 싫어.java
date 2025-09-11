import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int basket = Integer.MIN_VALUE;    
        for (Integer i : arr) {            
            if (i.equals(basket)) continue;
            deque.add(i);
            basket = i;
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}