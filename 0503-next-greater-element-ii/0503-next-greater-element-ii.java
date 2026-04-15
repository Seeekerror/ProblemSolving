class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*nums.length-1; i >= 0; i--){
            int idx = i%nums.length;
            while(!st.isEmpty() && st.peek() <= nums[idx]){
                st.pop();
            }
            //if(i < nums.length)
                ans[idx] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[idx]);
        }
        return ans;
    }
}