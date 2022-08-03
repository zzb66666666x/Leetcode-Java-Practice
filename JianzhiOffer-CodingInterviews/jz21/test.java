// my method
// class Solution {
//     public int[] exchange(int[] nums) {
//         if (nums == null)
//             return null;
//         if (nums.length < 2)
//             return nums;
//         int ret = -1;
//         for (int i=0; i<nums.length; i++){
//             if ((nums[i] & 1) == 0){
//                 ret = find(nums, (ret < 0)? i+1 : ret+1);
//                 if (ret < 0)
//                     return nums;
//                 swap(nums, i, ret);
//             }
//         }
//         return nums;
//     }

//     private int find(int[] nums, int start){
//         while (start < nums.length){
//             if ((nums[start] & 1) > 0){
//                 return start;
//             }
//             start++;
//         }
//         return -1;
//     }

//     private void swap(int[] nums, int idx1, int idx2){
//         int val = nums[idx2];
//         nums[idx2] = nums[idx1];
//         nums[idx1] = val;
//     }
// }

// head pointer and end pointer
class Solution{
    public int[] exchange(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<j){
            while (i<j && (nums[i]&1)>0){
                i++;
            }
            while (i<j && (nums[j]&1)==0){
                j--;
            }
            // if (i>=j)
            //     return nums;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}



