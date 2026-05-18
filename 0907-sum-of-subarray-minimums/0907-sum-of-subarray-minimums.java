class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()] > arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? i+1 : i-s.peek();
            s.push(i);
        }
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n-i : st.peek()-i;
            st.push(i);
        }
        int mod = 1_000_000_007;
        long ans=0;
        for(int i=0;i<n;i++){
            int hlp = (int)((1L * arr[i] * left[i] * right[i]) % mod);
            ans = (ans+hlp)%mod;
        }
        return (int)ans;
    }
}