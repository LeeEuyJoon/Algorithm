import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> uniqueNumsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        int uniqueNumsNums = uniqueNumsSet.size();
        
        if (nums.length / 2 >= uniqueNumsNums ) {
            return uniqueNumsNums;
        } else {
            return nums.length / 2;
        }
        
    }
}