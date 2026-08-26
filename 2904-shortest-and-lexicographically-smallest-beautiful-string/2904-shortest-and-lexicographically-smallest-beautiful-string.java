class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> ls = new ArrayList<>();
        int l = 0;
        int r = 0;
        int x = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            if (s.charAt(r) == '1')
                x++;
            while (x > k) {
                if (s.charAt(l) == '1')
                    x--;
                l++;
            }
            if (x == k) {
                while(s.charAt(l) == '0') l++;
                len = Math.min(len, r - l + 1);
            }
            r++;
        }
        for (int i = 0; i < s.length(); i++) {
            int z = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    z++;
                if (z > k)
                    break;
                if (z == k && j - i + 1 == len) {
                    ls.add(s.substring(i, j + 1));
                }
            }
        }
        Collections.sort(ls);
        if (ls.size() == 0)
            return "";
        return ls.get(0);
    }
}