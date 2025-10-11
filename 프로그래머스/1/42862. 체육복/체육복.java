class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 숫자 작은 번호부터 돌면서 reserve의 인덱스를 저장해놓으면 될 듯

        int index = 0;
        
        for (int l: lost) {
            for (int i = index; i < reserve.length; i++) {
                if (Math.abs(reserve[i] - l) <= 1) {
                    index++;
                    continue;
                }
            }
        }
        
        return n - lost.length + index;
        
    }
}