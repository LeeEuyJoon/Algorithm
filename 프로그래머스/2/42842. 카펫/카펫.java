import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 가로, 세로는 길이는 최소 3 이상
        // brown 개수는 (가로 길이) * 2 + (세로 길이) * 2 - 4
        // a: 가로 길이 , h: 세로 길이
        // b = a * 2 + h * 2 - 4
        // yellow 개수는 ...?
        // b + y = a * h
        // return [a, h]
        
        // brown: 10, yellow: 2
        // 10 = a * 2 + h * 2 - 4
        // 12 = a * h
        
        // h를 3부터 넣으면서 12 = a * h 이 식으로 h 딱 떨어지는 경우에 대해 첫 번째 방정식에 대입해서 ㅇㅋ이면 리턴
        
        int h = 3;
        int a;
        
        while (true) {
            if ((brown + yellow) % h == 0) {
                a = (brown + yellow) / h;
                if (brown == a * 2 + h * 2 - 4) return new int[]{a, h};
            }
            h++;
        }        
        
    }
}