import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호부 정렬
        Arrays.sort(phone_book);
        // 전화번호부에서 연속된 두 개의 전화번호 비교
        for (int i = 0; i < phone_book.length -1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }
        
        return true;
    }
}