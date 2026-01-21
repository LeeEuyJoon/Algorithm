class Solution {
    public int[] solution(int[] sequence, int k) {
        
        // 투포인터?
        // 인덱스 0, 1 부터 시작해서
        // 합이 k 이하면 right를 +1 하고 sum += seuquence[right]
        // 합이 k 이상이면 sum -= sequence[left] 하고 left를 +1
        // 합이 k면 리턴
        
        // 어 길이 짧은거 어떻게 구하지
        // sum == k 일 때 length 저장
        // 이후 또 sum == k 일때 length랑 비교해서 더 최솟값인 
        
        int n = sequence.length;
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int bestL = 0;
        int bestR = 0;
        int bestLen = Integer.MAX_VALUE;
        
        while (left < n && right < n) {
            if (sum == k) {
                int len = right - left +1;
                if (len < bestLen) {
                    bestLen = len;
                    bestL = left;
                    bestR = right;
                }
                sum -= sequence[left];
                left++;
            }
            if (sum < k) {
                right++;
                if (right == n) break;
                sum += sequence[right];
            }
            if (sum > k) {
                sum -= sequence[left];
                left++;
            }

        }
        
        return new int[]{bestL, bestR};
    }
}