// method 1: based on the idea of qsort
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int i=l;
        int j=l;
        for (; nums[i] <= pivot && i<r; i++, j++){}
        for (; j<r; j++){
            if (nums[j] <= pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, r, i);
        return i;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }
}

// method2: based on priorityqueue
// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于K，将当前数字放入堆中。
// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
// class Solution {
//     public int[] getLeastNumbers(int[] arr, int k) {
//         if (k == 0 || arr.length == 0) {
//             return new int[0];
//         }
//         // 默认是小根堆，实现大根堆需要重写一下比较器。
//         Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
//         for (int num: arr) {
//             if (pq.size() < k) {
//                 pq.offer(num);
//             } else if (num < pq.peek()) {
//                 pq.poll();
//                 pq.offer(num);
//             }
//         }
        
//         // 返回堆中的元素
//         int[] res = new int[pq.size()];
//         int idx = 0;
//         for(int num: pq) {
//             res[idx++] = num;
//         }
//         return res;
//     }
// }

// 作者：sweetiee
// 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
