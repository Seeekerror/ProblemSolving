class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int x = (arr[i]%k+k)%k;
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int key : map.keySet()){
            if(key == 0){
                if(map.get(key) % 2 != 0){
                    return false;
                }
            }
            else {
                int other = k - key;
                int ky = map.getOrDefault(other, 0);
                if (map.get(key) != ky) {
                    return false;
                }
            }
        }
        return true;
    }
}