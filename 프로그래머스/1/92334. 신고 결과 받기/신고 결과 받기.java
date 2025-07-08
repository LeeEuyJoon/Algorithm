import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 신고 당한 횟수
        HashMap<String, Integer> reportMap = new HashMap<>();
        
        // 신고자
        HashMap<String, ArrayList<String>> reporterMap = new HashMap<>();
        
        // 활동제한자 (k번 이상 신고 받은 사람)
        ArrayList<String> restricted = new ArrayList<String>();
        
        // 리턴
        int[] result = new int[id_list.length];
        
        // 리포트 중복 제거
        Set<String> uniq = new HashSet<>(Arrays.asList(report));
        
        for (String s: uniq) {
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            ArrayList<String> list = reporterMap.getOrDefault(reporter, new ArrayList<>());
            reportMap.put(reported, reportMap.getOrDefault(reported, 0) + 1);
            list.add(reported);
            reporterMap.put(reporter, list);
        }
        
        for (String s: id_list) {
            if (reportMap.getOrDefault(s, 0) >= k) {
                restricted.add(s);
            }
        }
        
        for (int i=0; i<id_list.length; i++) {
            Integer mailCount = 0;
            for (String reported: reporterMap.getOrDefault(id_list[i], new ArrayList<>())) {
                if (restricted.contains(reported)) {
                    mailCount++;
                }
            }
            result[i] = mailCount;
        }
        
        
        
        
        return result;
    }
}