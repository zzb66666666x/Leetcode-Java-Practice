// Hashset method: slow and cost a lot memory
// import java.util.Map.Entry;
// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> m = new HashMap<>();
//         int half = nums.length/2;
//         for (int k : nums){
//             if (m.containsKey(k)){
//                 m.put(k,m.get(k)+1);
//             }else{
//                 m.put(k, 1);
//             }
//         }
//         for (Entry<Integer, Integer> entry: m.entrySet()){
//             if (entry.getValue()>half){
//                 return entry.getKey();
//             }
//         }
//         return 0;
//     }
// }

// just sort it: it's actually fast
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];
//     }
// }

// the Moore vote method: best
// 假设有一个擂台，有一组人，每个人有编号，相同编号为一组，依次上场，没人时上去的便是擂主（x），若有人，编号相同则继续站着（人数+1），若不同，假设每个人战斗力相同，都同归于尽，则人数-1；那么到最后站着的肯定是人数占绝对优势的那一组啦~
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

// 作者：jyd
// 链接：https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

