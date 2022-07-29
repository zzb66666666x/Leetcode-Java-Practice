// method1: brute force
// class Solution {
//     public int[][] findContinuousSequence(int target) {
//         if (target == 1){
//             int[][] ret = new int[1][2];
//             ret[0][0] = 0; ret[0][1] = 1;
//             return ret;
//         }
//         int starter = target / 2 + 1;
//         ArrayList<ArrayList<Integer>> l = new ArrayList<>();
//         for (; starter>0; starter--){
//             int tmp = starter;
//             int sum = 0;
//             ArrayList<Integer> newlist = new ArrayList<Integer>();
//             for (; tmp >=0; tmp--){
//                 sum += tmp;
//                 newlist.add(tmp);
//                 if (sum > target){
//                     break;
//                 }else if (sum == target){
//                     l.add(newlist);
//                     break;
//                 }
//             }
//         }
//         int[][] ret = new int[l.size()][];
//         int arridx = 0;
//         for (int tmpidx=l.size()-1; tmpidx>=0; tmpidx--){
//             ArrayList<Integer> tmpl = l.get(tmpidx);
//             int[] arr = new int[tmpl.size()];
//             int idx=0;
//             for (int i=tmpl.size()-1; i>=0; i--, idx++){
//                 arr[idx] = tmpl.get(i);
//             }
//             ret[arridx++] = arr;
//         }
//         return ret;
//     }
// }

// method2: sliding window
class Solution{
    public int[][] findContinuousSequence(int target) {
	int i = 1; // 滑动窗口的左边界
	int j = 1; // 滑动窗口的右边界
	int sum = 0; // 滑动窗口中数字的和
	List<int[]> res = new ArrayList<>();

	while (i <= target / 2) {
	    if (sum < target) {
		// 右边界向右移动
		sum += j;
		j++;
	    } else if (sum > target) {
		// 左边界向右移动
		sum -= i;
		i++;
	    } else {
		// 记录结果
		int[] arr = new int[j-i];
		for (int k = i; k < j; k++) {
		    arr[k-i] = k;
		}
		res.add(arr);
		// 左边界向右移动
		sum -= i;
		i++;
	    }
	}

	return res.toArray(new int[res.size()][]);
    }
}
// 作者：nettee
// 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

