import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

        // 배열에서 중복 제거를 하고
        // 배열 길이 / 2 > 유니크 개수 ? 유니크 개수 : 배열 길이 / 2
        
        HashSet<Integer> set = new HashSet<>();
        
        for (Integer pokemon: nums) {
            set.add(pokemon);
        }
        
        if (nums.length / 2 > set.size()) {
            return set.size();
        }
        
        return nums.length / 2;
        
    }
}