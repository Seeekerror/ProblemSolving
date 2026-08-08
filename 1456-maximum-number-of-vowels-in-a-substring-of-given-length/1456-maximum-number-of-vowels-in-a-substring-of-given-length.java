class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int max = 0;
        int c = 0;
        while (j < s.length()) {
            if (s.charAt(j) == 'a' || s.charAt(j) == 'e' ||
                    s.charAt(j) == 'i' || s.charAt(j) == 'o' ||
                    s.charAt(j) == 'u') {
                c++;
            }
            while (j-i+1 > k) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                        s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
                        s.charAt(i) == 'u') {
                    c--;
                }
                i++;
            }
            max = Math.max(c,max);
            j++;
        }
        return max;
    }
}