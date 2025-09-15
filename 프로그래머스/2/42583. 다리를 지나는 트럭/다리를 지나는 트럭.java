import java.util.ArrayDeque;

class Solution {
    
    private class Truck {
        
        int index = 0;
        int weight;
        int bridge_length;

        public Truck(int weight, int bridge_length) {
            this.weight = weight;
            this.bridge_length = bridge_length;
        }
        
        public void plusIndex() {
            this.index++;
        }
        
        public boolean isEnd() {
            if (this.index >= bridge_length) {
                return true;
            }
            return false;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 큐 무게 합친 변수 두고 큐에서 add 하거나 poll 할 떄마다 변수 업데이트
        // 기존 큐 무게 + 현재 무게가 weight을 초과 할 경우 대기
        
        ArrayDeque<Truck> queue = new ArrayDeque<>();
        
        Truck firstTruck = new Truck(truck_weights[0], bridge_length);
        
        queue.add(firstTruck);
        
        int sumWeight = truck_weights[0];
        int totalTime = 1;
        int i =1;

        // 트럭이 한 대 일때는 무조건 길이 + 1
        if (truck_weights.length == 1) return bridge_length + 1;    
        
        while (!queue.isEmpty() || i < truck_weights.length) {
            
            // 큐에 있는 노드들 한 칸 이동
            for (Truck truck: queue) {
                truck.plusIndex();
            }
            
            // 다리 끝에 도달한 트럭 제거
            while (!queue.isEmpty() && queue.peek().isEnd()) {
                sumWeight -= queue.poll().weight;
            }
            
            // 대기 트럭 남아있고 다리에 올릴 수 있으면 올리기
            if (i < truck_weights.length && sumWeight + truck_weights[i] <= weight) {
                queue.add(new Truck(truck_weights[i], bridge_length));
                sumWeight += truck_weights[i];
                i++;
            }
            
            totalTime++;
            
        }
        
        return totalTime;
        
    }
}