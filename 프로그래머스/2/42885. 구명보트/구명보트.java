import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 오름차순 정렬하고
        // 투포인터
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        
        while (left <= right) {
            // 젤 가벼운 사람이랑 젤 무거운 사람의 무게 합과 limit 비교
            if (people[left] + people[right] <= limit) {
                left++;
            }
            
            // 아니면 가벼운 사람 남기고 무거운 사람 혼자 태우기
            // 그 다음에 loop에서 기존 가벼운 사람이랑 다음 덜 무거운 사람 같이 태워서 비교
            right--;
            boats++;
        }
        
        return boats;
        
        
    }
}