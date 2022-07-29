class Solution {
    public int[] singleNumbers(int[] nums) {
        int mask = 0;
        for (int val : nums){
            mask = mask ^ val;
        }
        // 寻找mask从右向左，第一位1
        // 普通方法：遍历bit位
        // 快速方法：n & (-n)
        // eg. n=1100 -> -n=0100 -> take & -> 0100
        int flag = mask & (-mask);
        int submask = 0;
        for (int i=0; i < nums.length; i++){
            if ((nums[i] & flag) != 0){
                submask ^= nums[i];
            }
        }
        int[] ret = new int[]{submask, submask^mask};
        return ret;
    }
}
