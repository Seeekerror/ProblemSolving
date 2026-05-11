class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String st = Integer.toString(nums[i]);
            for(int j=0;j<st.length();j++){
                l.add(st.charAt(j)-'0');
            }
        }
        int [] arr = new int[l.size()];
        int i=0;
        for(int x : l){
            arr[i++] = x;
        }
        return arr;
    }
}
