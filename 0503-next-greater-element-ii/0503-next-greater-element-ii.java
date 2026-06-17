class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*nums.length-1; i >= 0; i--){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx] >= st.peek()){
                st.pop();
            }
            if(i < nums.length)
                ans[idx] = st.isEmpty() ? -1 : st.peek();
            
            st.push(nums[idx]);
        }
        return ans;
    }
}