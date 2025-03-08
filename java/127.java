class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        for (String word : wordList) {
            visited.put(word, false);
        }
        Queue <String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            Queue <String> newQueue = new LinkedList<String>();
            while (!queue.isEmpty()) {
                String currentWord = queue.remove();
                if (currentWord.equals(endWord)) {
                    return length;
                }
                for (String nextWord : wordList) {
                    if (isLessThan1LetterDiff(currentWord, nextWord)) {
                        if (visited.get(nextWord) == false) {
                            visited.put(nextWord, true);
                            newQueue.add(nextWord);
                        }
                    }
                }
            }
            queue = newQueue;
            length++;
        }
        return 0;
    }

    public boolean isLessThan1LetterDiff(String left, String right) {
        int count = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}