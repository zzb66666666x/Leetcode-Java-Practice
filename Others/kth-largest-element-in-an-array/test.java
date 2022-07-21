class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qsearch(nums, 0, nums.length-1, k-1);
    }

    private int qsearch(int[] nums, int l, int r, int k){ // find the element with lower index k
        if (l>=r)
            return nums[l];
        int p = partition(nums, l, r, k);
        if (p==k)
            return nums[p];
        return k<p ? qsearch(nums, l, p-1, k) : qsearch(nums, p+1, r, k);
    }

    private int partition(int[] nums, int l, int r, int k){
        int pivot = nums[r];
        int i,j;
        i=l; j=l;
        for (; nums[i] > pivot; i++, j++){}
        for (; j<r; j++){
            if (nums[j]>pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}
