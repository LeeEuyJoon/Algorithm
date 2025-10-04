import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        
        // 3, 0, 6, 1, 5
        // 0, 1, 3, 5, 6
        
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i; 
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}