class Solution {
    public String evaluate(String s, List<List<String>> know) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < know.size(); i++) {
            String key = know.get(i).get(0);
            String val = know.get(i).get(1);
            map.put(key, val);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '(') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                int j = i;
                while (s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(j + 1, i);
                if (map.containsKey(key)) {
                    sb.append(map.get(key));
                } else {
                    sb.append('?');
                }

            }
            i++;
        }
        return sb.toString();
    }
}
