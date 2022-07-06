class Solution {
    public int missingNumber(int[] nums) {
        int maxval = nums.length;
        int checker = 0;
        for (int i = 0; i <= maxval; i++){
            checker = checker ^ i;
        }
        for (int i=0; i < nums.length; i++){
            checker = checker ^ nums[i];
        }
        return checker;
    }
}