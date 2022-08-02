// merge sort method
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] tmp = new int[nums.length];
        return mergeSort(nums, tmp, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int[] tmp, int l, int r){
        if (l >= r){
            return 0;
        }
        int mid = (l + r)/2;
        int inv_count = mergeSort(nums, tmp, l, mid) + mergeSort(nums, tmp, mid+1, r);
        int pos = l;
        int i = l;
        int j = mid+1;
        while(i<=mid && j<=r){
            if (nums[i] <= nums[j]){
                inv_count += (j-(mid+1));
                tmp[pos++] = nums[i++];
            }else{
                tmp[pos++] = nums[j++];
            }
        }
        for (int k=i; k<=mid; k++){
            inv_count += (j-(mid+1));
            tmp[pos++] = nums[k];
        }
        for (int k=j; k<=r; k++){
            tmp[pos++] = nums[k];
        }
        copy(tmp, nums, l, r);
        return inv_count;
    }

    private void copy(int[] src, int[] dst, int s, int e){
        for (int i=s; i<=e; i++){
            dst[i] = src[i];
        }
    }
}
