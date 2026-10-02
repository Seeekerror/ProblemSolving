class Solution {
    List<String> l = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        solve(n, sb);
        return l;
    }

    void solve(int n, StringBuilder sb) {
        if (sb.length() == n * 2) {
            if (isPar(sb.toString())) {
                l.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        solve(n, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        solve(n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    boolean isPar(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}