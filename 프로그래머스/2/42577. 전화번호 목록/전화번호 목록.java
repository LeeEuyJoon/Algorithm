import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean solution(String[] phone_book) {

        // 폰북을 사전순으로 정렬하고
        Arrays.sort(phone_book);
        
        // 인접한 폰번호만 접두어 검사
        for ( int i = 0; i < phone_book.length-1; i++ ) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;   
            }
        }
        
        return true;
    }
}