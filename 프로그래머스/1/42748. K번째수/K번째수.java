import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        int i = 0;
        for (int[] c: commands) {
            int[] slicedArr = Arrays.copyOfRange(array, c[0] - 1, c[1]);
            Arrays.sort(slicedArr);
            answer[i++] = slicedArr[c[2]-1];
        }
        
        return answer;

    }
}