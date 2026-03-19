class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else if(st.isEmpty() && s.charAt(i) == ')'){
                count++;
            }
            else{
                st.pop();
            }
        }
        int ans = 0;
        if(!st.isEmpty()){
            ans = count + st.size();
        }else{
            return count;
        }
        return ans;
    }
}