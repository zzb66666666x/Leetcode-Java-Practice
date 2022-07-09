class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxnum = nums[0];
        int maxidx = 0;
        for (int i=1; i<nums.length; i++){
            if (maxidx + k < i){
                // update maxnum, maxidx
                // System.out.println("updated at i="+i);
                maxnum = Integer.MIN_VALUE;
                int idx = i-1;
                while (idx >=0 && idx >= i - k){
                    if (dp[idx] > maxnum){
                        maxnum = dp[idx];
                        maxidx = idx;
                    }
                    idx--;
                }
            }
            dp[i] = maxnum + nums[i];
            if (dp[i] >= maxnum){
                maxnum = dp[i];
                maxidx = i;
            }
            // printlist(dp);
            // System.out.println("maxidx="+maxidx);
        }
        return dp[nums.length-1];
    }

    private void printlist(int[] mylist){
        for (int i=0; i<mylist.length; i++){
            System.out.printf("%d ", mylist[i]);
        }
        System.out.printf("\n");
    }
}
