class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null)
            return null;
        if (nums.length < 2)
            return nums;
        for (int i=0; i<nums.length; i++){
            if (nums[i] % 2 == 0){
                int ret = find(nums, i+1);
                if (ret < 0)
                    return nums;
                swap(nums, i, ret);
            }
        }
        return nums;
    }

    private int find(int[] nums, int start){
        while (start < nums.length){
            if (nums[start] % 2 != 0){
                return start;
            }
            start++;
        }
        return -1;
    }

    private void swap(int[] nums, int idx1, int idx2){
        int val = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = val;
    }
}
