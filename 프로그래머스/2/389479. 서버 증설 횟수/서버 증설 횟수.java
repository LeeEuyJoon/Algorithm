import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        // m명 늘어날 때마다 서버 1대 증설되며 k 시간 유지됨
        // 시각 | 게임 이용자 수 | 증설된 서버 수 | 증설 횟수
        
        // 증설될 때마다 증설된 서버 수를 업데이트 (Hash Map?) 
        // 전체 순회 돌리리면서
        // 플레이어 수와 현재 서버 수 비교
        // 서버 수 * m < 플레이어 수 -> 서버 증설 -> 서버 수 업데이트
        // 매 순회 시작할 때마다 시간 지난 서버 개수만큼 서버 수 빼기
        
        // 조아 가자
        
        // HashMap<증설한 시간: 증설 개수>
        // ex) 0:3, 1:2 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int loop = 0;
        int server = 0;
        int plusServer = 0;
        
        for (int player: players) {
            // 증설한 서버 시간 지난거 내리기
            if ( map.containsKey(loop-k) ) {
                server -= map.get(loop-k);
                map.remove(loop-k);
            }
            
            // 플레이어 수랑 서버 수 비교하기
            if ( server * m < player ) {
                // 추가로 필요한 서버 개수
                int needServer = ( player / m ) - server;
                
                // 서버 추가
                server += needServer;
                map.put(loop, needServer);
                plusServer += needServer;
            }
            
            loop++;
        }
        
        return plusServer;
    }
}