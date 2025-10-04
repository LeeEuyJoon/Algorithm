import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        
        // 1. Insert -> add 한다
        // 2. D -1 -> remove 한다
        // 3. D 1 -> pq를 하나 더 만들어서 옮겨 담는데 이때 기준을 reverse로 하고 remove 하고 다시 원래 우선순위로 기존 pq에 담는다
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String s: operations) {
            String[] parts = s.split(" ");
            String command = parts[0];
            Integer number = Integer.parseInt(parts[1]);
            
            if (command.equals("I")) {
                pq.add(number);
            }
            if (command.equals("D")) {
                if (number == 1) {
                    if (!pq.isEmpty()) {     
                        while (!pq.isEmpty()) {
                            pq2.add(pq.poll());
                        }
                        pq2.poll();
                        while (!pq2.isEmpty()) {
                            pq.add(pq2.poll());
                        }
                    }
                }
                if (number == -1) {
                    if (!pq.isEmpty()) {
                        pq.remove();
                    }
                }
            }
        }
        
        if (pq.isEmpty()) return new int[]{0, 0};

        int max = Collections.max(pq);
        int min = Collections.min(pq);

        return new int[]{max, min};

    }
}