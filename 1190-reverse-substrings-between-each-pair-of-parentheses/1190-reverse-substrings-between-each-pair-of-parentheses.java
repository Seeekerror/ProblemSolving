class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String curr = "";

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(curr);
                curr = "";
            }

            else if (ch == ')') {
                curr = new StringBuilder(curr).reverse().toString();
                curr = st.pop() + curr;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}