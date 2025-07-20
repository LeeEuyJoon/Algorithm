import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        
        HashMap<Integer, Integer> playerCnt = new HashMap<>();
        HashSet<String> uniqueWords = new HashSet<>();
        
        int player;
        Character firstAlphabet = null;
        String word = null;
        
        for (int i = 0; i<words.length; i++) {
            player = i % n + 1;
            word = words[i];
            
            if (check(word, firstAlphabet, uniqueWords)) {
                playerCnt.put(player, playerCnt.getOrDefault(player, 0) + 1);
                uniqueWords.add(word);
            } else {
                return new int[] {player, playerCnt.getOrDefault(player, 0) + 1};
            }
                
            firstAlphabet = word.charAt(word.length() - 1);
        }

        return new int[] {0, 0};
    }
            private boolean check(String word, Character first, Set<String> used) {
                if (first == null)  {
                    return true;
                }
                
                if (word.charAt(0) != first || used.contains(word)) {
                    return false;
                }
            return true;
        }
                

}