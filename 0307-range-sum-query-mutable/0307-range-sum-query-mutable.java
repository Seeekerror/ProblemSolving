class NumArray {
    int [] num;
    int [] seg;
    public NumArray(int[] nums) {
        num = nums;
        seg = new int[4*num.length];
        build(num,seg,0,num.length-1,0);
    }
    public void build(int [] num,int [] seg, int l , int r, int idx){
        if(l == r){
            seg[idx] = num[l];
            return;
        }
        int m = l+(r-l)/2;
        build(num,seg,l,m,2*idx+1);
        build(num,seg,m+1,r,2*idx+2);

        seg[idx] = seg[2*idx+1]+seg[2*idx+2];
    }
    
    public void update(int index, int val) {
        Update(index,val,0,0,num.length-1);
    }
    void Update(int index, int val,int idx,int l, int r){
        if(l == r){
            seg[idx] = val; 
            return;
        }
        int m = l + (r-l)/2;
        if(index <= m){
            Update(index,val,2*idx+1,l,m);
        }else {
            Update(index,val,2*idx+2,m+1,r);
        }
        seg[idx] = seg[2*idx+1]+seg[2*idx+2];
    }
    
    public int sumRange(int left, int right) {
        return query(left,right,0,0,num.length-1);
    }
    int query(int ql, int qr,int idx, int l, int r){
        if(r < ql || l > qr) return 0;
        if(l >= ql && r <= qr){
            return seg[idx];
        }
        int m = l + (r-l)/2;
        int left = query(ql,qr,2*idx+1,l,m);
        int right = query(ql,qr,2*idx+2,m+1,r);

        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */