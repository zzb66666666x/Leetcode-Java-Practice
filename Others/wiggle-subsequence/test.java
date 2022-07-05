

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}

public class test{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,7,4,9,2,5};
        System.out.println(sol.wiggleMaxLength(nums));
    } 
}