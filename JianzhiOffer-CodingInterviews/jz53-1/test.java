class Solution {
    public int search(int[] nums, int target) {
        int idx = _search(nums, 0, nums.length-1, target);
        // probe to the left and right
        if (idx < 0)
            return 0;
        int cnt = 1;
        int tmp = idx-1;
        while (tmp>=0){
            if (nums[tmp] == target)
                cnt++;
            tmp--;
        }
        tmp = idx+1;
        while (tmp <= nums.length-1){
            if (nums[tmp] == target)
                cnt++;
            tmp++;
        }
        return cnt;
    }

    private int _search(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;
        int mid = (left+right)/2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid]>target){
            return _search(nums, left, mid-1, target);
        }else{
            return _search(nums, mid+1, right, target);
        }
    }
}