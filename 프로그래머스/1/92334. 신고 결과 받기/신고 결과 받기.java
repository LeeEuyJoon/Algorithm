import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String r : report) {
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if (!reportedUser.containsKey(reportedId)) { 
                reportedUser.put(reportedId, new HashSet<>());    
            }       
            reportedUser.get(reportedId).add(userId);
        }
        
        for (Map.Entry<String, HashSet<String>> entry: reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}