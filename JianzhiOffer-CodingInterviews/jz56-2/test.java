class Solution {
public int singleNumber(int[] nums) {
    int ones = 0, twos = 0;
    for(int num : nums){
	ones = ones ^ num & ~twos;
	twos = twos ^ num & ~ones;
    }
    return ones;
}
}

// 作者：jyd
// 链接：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
