class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int fleet = length;
        Map<Integer, Integer> prevCarMap = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> currCarMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            prevCarMap.put(position[i], speed[i]);
        }
        while (prevCarMap.size() > 1) {
            int currFleetPosition = -1;
            int currFleetSpeed = 0;
            boolean isFirstFleet = true;
            Stack<Pair<Integer, Integer>> carFleetStack = new Stack<Pair<Integer, Integer>>();
            for (int carPosition : prevCarMap.keySet()) {
                int carSpeed = prevCarMap.get(carPosition);
                int nextCarPosition = carPosition + carSpeed;
                if (carPosition >= target) {
                    continue;
                }
                Pair<Integer, Integer> carFleetPair = new Pair<Integer, Integer>(-1,-1);
                    while (!carFleetStack.empty() && carFleetStack.peek().getKey() >= nextCarPosition && carFleetStack.peek() != carFleetPair) {
                        carFleetPair = carFleetStack.peek();
                        int fleetSpeed = carFleetPair.getValue();
                        int fleetPosition = carFleetPair.getKey() - fleetSpeed;
                        boolean isCollide = false;

                        if (fleetSpeed > carSpeed) {
                            float time = ((float)carPosition - (float)fleetPosition) / ((float)fleetSpeed - (float)carSpeed);
                            float collidePosition = (float)carPosition + time * (float)carSpeed;
                            if (collidePosition <= target) {
                                isCollide = true;
                            }
                        }

                        if (isCollide) {
                            carFleetStack.pop();
                            fleet--;
                            if (carFleetPair.getValue() < carSpeed) {
                                carSpeed = carFleetPair.getValue();
                            }
                        }
                    }
                carFleetStack.push(new Pair<Integer, Integer>(nextCarPosition, carSpeed));
            }

            prevCarMap.clear();
            while (!carFleetStack.empty()) {
                Pair<Integer, Integer> carFleetPair = carFleetStack.peek();
                carFleetStack.pop();
                prevCarMap.put(carFleetPair.getKey(), carFleetPair.getValue());
            }
        }
        return fleet;
    }
}