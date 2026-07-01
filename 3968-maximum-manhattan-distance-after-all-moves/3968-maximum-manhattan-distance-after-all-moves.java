class Solution {
    public int maxDistance(String moves) {
        int u = 0;
        int l=0;
        int r=0;
        int d=0;
        int space=0;
        for(int i = 0;i < moves.length();i++){
            if(moves.charAt(i) == 'U'){
                u++;
            }
            else if(moves.charAt(i) == 'L'){
                l++;
            }
            else if(moves.charAt(i) == 'D'){
                d++;
            }
            else if(moves.charAt(i) == 'R'){
                r++;
            }
            else{
                space++;
            }
        }
        int ans1 = Math.abs(l-r);
        int ans2 = Math.abs(d-u);
        return ans1+ans2+space;
    }
}