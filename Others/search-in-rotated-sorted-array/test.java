class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target ? 0:-1;
        }
        return search(nums, target, 0, nums.length-1);
    } 

    private int search(int[] nums, int target, int l, int r){
        if(l>=r){
            return nums[l] == target ? l: -1;
        }
        int mid = (l+r)/2;
        // System.out.printf("(%d, %d) mid=%d, val=%d\n", l, r, mid, nums[mid]);
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > nums[l]){
            if (target < nums[mid]){
                return target < nums[l] ? search(nums, target, mid+1, r) : search(nums, target, l, mid-1);
            }else{
                return search(nums, target, mid+1, r);
            }
        }else if (nums[mid] < nums[l]){
            if (target < nums[mid]){
                return search(nums, target, l, mid-1);
            }else{
                return target < nums[l] ? search(nums, target, mid+1, r) : search(nums, target, l, mid-1);
            }
        }else{
            return search(nums, target, l+1, r);
        }
    }
}
