import java.util.*;

// ref: https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/2319923/JAVA-oror-100-faster-code
class Solution {    
    public List<Integer> countSmaller(int[] nums) {
        int min = 20001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        min--;
        int[] count = new int[max-min+1];
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            int k = nums[i]-min-1;
            int c = 0;
            do {
                c += count[k];
                k -= (-k&k);
            } while (k > 0);
            result[i] = c;
            
            k = nums[i]-min;
            while (k < count.length) {
                count[k]++;
                k += (-k&k);
            }
        }
        
        return Arrays.asList(result);
    }
}

public class test{
    public static void main(String[] args){
        int[] nums = new int[]{5,2,6,1};
        Solution sol = new Solution();
        sol.countSmaller(nums);
    }
}