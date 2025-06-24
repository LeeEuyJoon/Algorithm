import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        int result = 0;
        
        for (int i=0; i<want.length; i++) {
            hashMap.put(want[i], number[i]);
        }
        
        for (int i=0; i<discount.length - want.length + 1; i++) {
            String[] weeklyDiscount = Arrays.copyOfRange(discount, i, i + 10);
            HashMap<String, Integer> weeklyWant = new HashMap<>(hashMap);
            Boolean isOk = true;
            for (String item: weeklyDiscount) {
                Integer cnt = weeklyWant.get(item);
                if (cnt != null && cnt > 0) {
                    weeklyWant.put(item, weeklyWant.get(item) - 1);
                } else {
                    isOk = false;
                }
            }
            if (isOk) {
                result++;
            }
        
        }
        
        
        return result;
    }
}