class Solution {
    List<String> l = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(n, "");
        return l;
    }

    void solve(int n, String s) {
        if (s.length() == n * 2) {
            if (isPar(s)) {
                l.add(s);
            }
            return;
        }
        solve(n, s+'(');
        solve(n, s+')');
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