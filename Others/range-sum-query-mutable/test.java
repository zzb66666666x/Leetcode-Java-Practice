
class NumArray {
    int n;
    int[] segTree;

    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        build(nums, 0, 0, n-1);
    }

    private void build(int[] nums, int node, int s, int e){
        if (s == e){
            segTree[node] = nums[s];
            return;
        }
        int mid = s + (e-s)/2;
        build(nums, node*2+1, s, mid);
        build(nums, node*2+2, mid+1, e);
        segTree[node] = segTree[node*2+1] + segTree[node*2+2];
    }
    
    public void update(int index, int val) {
        _update(index, val, 0, 0, n-1); // start from root node = 0
    }

    private void _update(int index, int val, int node, int s, int e){
        if (s == e){
            segTree[node] = val;
            return;
        }
        int mid = s + (e-s)/2;
        if (index <= mid){
            _update(index, val, node*2+1, s, mid);
        }else{
            _update(index, val, node*2+2, mid+1, e);
        }
        segTree[node] = segTree[2*node+1] + segTree[2*node+2];
    }
    
    public int sumRange(int left, int right) {
        return _query(left, right, 0, 0, n-1);
    }

    private int _query(int left, int right, int node, int s, int e){
        if (left==s && right==e)
            return segTree[node];
        int mid = s + (e-s)/2;
        if (left>mid)
            return _query(left, right, node*2+2, mid+1, e);
        if (right<=mid)
            return _query(left, right, node*2+1, s, mid);
        return _query(mid+1, right, node*2+2, mid+1, e) + _query(left, mid, node*2+1, s, mid);
    }   
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

public class test{
    public static void main(String[] args){
        int[] nums = new int[]{-28,-39,53,65,11,-56,-65,-39,-43,97};
        NumArray na = new NumArray(nums);
    }
}