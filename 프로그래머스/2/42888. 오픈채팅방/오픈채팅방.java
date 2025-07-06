import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        // Enter/Leave 메세지를 저장할 해시맵
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
        
        HashMap<String, String> uid = new HashMap<>();
        
        // record의 각 줄을 하나씩 처리
        for (String s: record) {
            String[] cmd = s.split(" ");
            if (cmd.length == 3) { // Enter or Change
                uid.put(cmd[1], cmd[2]);
            }
        }
        
        // 답을 저장할 answer list
        ArrayList<String> answer = new ArrayList<>();
        
        for (String s : record) {
            String[] cmd = s.split(" ");
            // 각 상태에 맞는 메세지 저장
            if (msg.containsKey(cmd[0])) {
                answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }
        
        return answer.toArray(new String[0]);
    }
}