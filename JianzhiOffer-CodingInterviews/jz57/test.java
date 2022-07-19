class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{target};
            }else{
                return new int[0];
            }
        }
        for (int idx1 = nums.length-1; idx1>=1; idx1--){
            int a = nums[idx1];
            if (a>target)
                continue;
            for (int idx2 = idx1 - 1; idx2>=0; idx2--){
                int b = nums[idx2];
                if (b>target)
                    continue;
                int val = a+b;
                if (val == target)
                    return new int[]{a,b};
                if (val < target)
                    break;
            }
        }
        return new int[0];
    }
}
