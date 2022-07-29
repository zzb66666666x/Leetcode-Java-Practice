// 链式前向星算法：用来高效建图，可以高效计算一个图节点的入度
// https://cloud.tencent.com/developer/article/1912251
// Overview如下
// struct node{
//     int to;    // same as int[] e below
//     int weight // not used here
//     int next;  // same as int[] ne below
// }edge[maxe];//边集数组，边数一般要设置比maxn*maxn大的数，如果题目有要求除外
// int head[maxn];//头结点数组, same as int[] he below

class Solution {
    int N = 10010, M = N, idx;
    int[] he = new int[N], e = new int[M], ne = new int[M], in = new int[N];
    void add(int a, int b) {
        e[idx] = b;         // add edge dest
        ne[idx] = he[a];    // let current edge points to the old edge which also has start node a
        he[a] = idx++;      // add edge head, increment edge index, he[startnode] points to the dest in e[]
        in[b]++;            // number of edges pointing to node b
    }
    public boolean sequenceReconstruction(int[] nums, int[][] ss) {
        int n = nums.length;
        Arrays.fill(he, -1);
        for (int[] s : ss) {
            for (int i = 1; i < s.length; i++) add(s[i - 1], s[i]);
        }
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) d.addLast(i);
        }
        int loc = 0;
        while (!d.isEmpty()) {
            if (d.size() != 1) return false; // 入度=0的点不止一个？直接return false
            int t = d.pollFirst();
            if (nums[loc++] != t) return false;
            for (int i = he[t]; i != -1; i = ne[i]) { // loop over all the edges that starts at node t
                int j = e[i]; // get the edge end point
                if (--in[j] == 0) d.addLast(j); // 如果发现入度恰好等于1，就加到队列里，留到下一轮判断
            }
        }
        return true;
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/ur2n8P/solution/by-ac_oier-oqxs/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
