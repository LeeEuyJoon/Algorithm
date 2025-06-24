import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (String string: completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }
        
        for (String string: participant) {
            if (hashMap.getOrDefault(string, 0) == 0) {
                return string;
            }
            hashMap.put(string, hashMap.get(string) - 1);
        }
        return null;
    }
}