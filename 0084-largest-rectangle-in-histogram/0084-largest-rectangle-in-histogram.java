class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int [] l = new int[n];
        int [] r = new int[n];

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                l[i] = -1;
            }else{
                l[i] = s.peek();
            }
            s.push(i);
        }

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                r[i] = n;
            }else{
                r[i] = st.peek();
            }
            st.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,(r[i]-l[i]-1)*heights[i]);
        }
        return ans;
    }
}