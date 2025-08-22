class Solution {
    public int[] solution(String s) {
        
        int countTransform = 0;
        int countZero = 0;
        
        while (!s.equals("1")) {
            
            countTransform++;
            
            int zero = s.replace("1", "").length();
            countZero += zero;

            s = Integer.toBinaryString(s.length() - zero);
        }
        
        return new int[]{countTransform, countZero};
    }
}