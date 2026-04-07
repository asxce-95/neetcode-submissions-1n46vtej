class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        
        Set<String> wordHash = new HashSet<>(wordList);

        if(!wordHash.contains(endWord)){
            return 0;
        }
        
        Map<String, Set<String>> adjMap = new HashMap<>();

        for (String word : wordList) {
            Set<String> neighbors = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                char[] wordArr = word.toCharArray();
                char ogChar = wordArr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    //System.out.println("Replacing " + wordArr[i] + " with " + i + " Char: " + c);

                    if (c == ogChar) continue;

                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    //System.out.println("OG Word: " + word + " i: " + i + " Char: " + c + " New Word : " + newWord);
                    if (wordHash.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
            adjMap.put(word, neighbors);
        }

        for (Map.Entry<String, Set<String>> entry : adjMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        int count = 1; // level starts from 1 (beginWord itself)
        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);
        q.addLast("##"); // level marker

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {
            String word = q.removeFirst();

            if (word.equals("##")) {
                // level ended
                if (q.isEmpty()) break; // no more words to process
                count++;
                q.addLast("##");
                continue;
            }

            if (word.equals(endWord)) {
                return count;
            }

            for (String nei : adjMap.get(word)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.addLast(nei);
                }
            }
        }

        

        return 0;
    }
}
