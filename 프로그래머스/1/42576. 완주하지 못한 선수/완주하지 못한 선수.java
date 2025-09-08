import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map =  new HashMap<>();
        
        // map 에 참가자를 map에 담으며 value 플러스
        for (String s: participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // 완주자를 순회하며 value 마이너스
        for (String s: completion) {
            map.put(s, map.get(s) - 1);
        }
        
        // map을 순회하며 value가 0이 아니면 리턴
        for (String key: map.keySet()) {
            if (!map.get(key).equals(0)) return key;
        }
        
        return "";
    }
}