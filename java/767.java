class Solution {
    public String reorganizeString(String s) {
        Comparator<Pair<Character, Integer>> comparator = new Comparator<Pair<Character, Integer>> () {
            @Override
            public int compare(Pair<Character, Integer> left, Pair<Character, Integer> right) {
                return -left.getValue().compareTo(right.getValue());
            }
        };
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>> (comparator);
        Map<Character, Integer> countMap = new HashMap<Character, Integer> ();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        for (Integer value : countMap.values()) {
            if (value > (s.length() - 1) / 2 + 1) {
                return "";
            }
        }
        for (Character key : countMap.keySet()) {
            int value = countMap.get(key);
            Pair<Character, Integer> pair = new Pair<Character, Integer> (key, value);
            pq.offer(pair);
        }
        String builtString = "";
        while (!pq.isEmpty()) {
            Pair<Character, Integer> curr = pq.poll();
            if (builtString.length() > 0 && builtString.charAt(builtString.length() - 1) == curr.getKey()) {
                Pair<Character, Integer> next = pq.poll();
                Character c = next.getKey();
                builtString += c;
                if (next.getValue() > 1) {
                    Pair<Character, Integer> newNext = new Pair<Character, Integer> (next.getKey(), next.getValue() - 1);
                    pq.offer(newNext);
                }
                pq.offer(curr);
            } else {
                builtString += curr.getKey();
                if (curr.getValue() > 1) {
                    Pair<Character, Integer> newCurr = new Pair<Character, Integer> (curr.getKey(), curr.getValue() - 1);
                    pq.offer(newCurr);
                }
            }
        }
        return builtString;
    }
}