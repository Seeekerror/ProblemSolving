class Solution {
    class Pair {
        String string;
        int count;

        Pair(String st, int c) {
            this.string = st;
            this.count = c;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            String word = temp.string;
            int cur = temp.count;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char [] arr = word.toCharArray();
                    arr[i] = (char)ch; 
                    String str = new String(arr);
                    if(set.contains(str)){
                        q.add(new Pair(str,cur+1));
                        set.remove(str);
                    }
                }
            }
            if(endWord.equals(word)){
                return cur;
            }
        }
        return 0;
    }
}