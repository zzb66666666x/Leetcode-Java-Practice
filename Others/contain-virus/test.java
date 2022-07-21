class Solution {
    int[][] g;
    int n, m, ans;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] vis;
    int search(int _x, int _y, Set<Integer> s1, Set<Integer> s2) {
        int ans = 0;
        Deque<int[]> d = new ArrayDeque<>();
        vis[_x][_y] = true;
        d.addLast(new int[]{_x, _y});
        s1.add(_x * m + _y);
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1], loc = nx * m + ny;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) continue;
                if (g[nx][ny] == 1) {
                    s1.add(loc);
                    vis[nx][ny] = true;
                    d.addLast(new int[]{nx, ny});
                } else if (g[nx][ny] == 0) {
                    s2.add(loc);
                    ans++;
                }
            }
        }
        return ans;
    }
    int getCnt() {
        vis = new boolean[n][m];
        int max = 0, ans = 0;
        // l1: 每个连通块的点集 l2: 每个连通块的候选感染点集
        List<Set<Integer>> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !vis[i][j]) {
                    // s1: 当前连通块的点集 s2: 当前连通块的候选感染点集
                    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
                    int b = search(i, j, s1, s2), a = s2.size();
                    if (a > max) {
                        max = a; ans = b;
                    }
                    l1.add(s1); l2.add(s2);
                }
            }
        }
        // 这for循环写得是真的秀
        // 对于感染危险最大的地区，遍历连通块已有的感染者，将g[x][y]设置为-1，表示已保护
        // 对于其他来不及加墙的地方，遍历新增感染者，设置g[x][y]为1，表示新增感染
        for (int i = 0; i < l2.size(); i++) {
            for (int loc : l2.get(i).size() == max ? l1.get(i) : l2.get(i)) {
                int x = loc / m, y = loc % m;
                g[x][y] = l2.get(i).size() == max ? -1 : 1;
            }
        }
        return ans;
    }
    public int containVirus(int[][] _g) {
        g = _g;
        n = g.length; m = g[0].length;
        while (true) {
            int cnt = getCnt();
            if (cnt == 0) break;
            ans += cnt;
        }
        return ans;
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/contain-virus/solution/by-ac_oier-l9ya/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
