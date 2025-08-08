import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        int number;
        int[] command;
        
        for (int i = 0; i < commands.length; i++) {
            command = commands[i];
            number = Arrays.stream(array, command[0] - 1, command[1])
                .sorted()
                .skip(command[2]-1)
                .findFirst()
                .orElseThrow();
            answer[i] = number;
        }
        
        return answer;
    }
}