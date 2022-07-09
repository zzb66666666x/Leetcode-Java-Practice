import java.util.HashMap;
import java.util.Map;

class Solution {
    char[] cs;
    String s;
    public int evaluate(String _s) {
        s = _s;
        cs = s.toCharArray();
        return dfs(0, cs.length - 1, new HashMap<>());
    }

    int dfs(int l, int r, Map<String, Integer> map) {
        if (cs[l] == '(') {
            int idx = l;
            while (cs[idx] != ' ') idx++;
            String op = s.substring(l + 1, idx);
            r--;
            if (op.equals("let")) {
                for (int i = idx + 1; i <= r; ) {// scan every expression within the "let"
                    int j = getRight(i, r);
                    String key = s.substring(i, j);
                    if (j >= r) // then we find the expression to evaluate, so use this layer's variable map (defined by "let") to calculate it
                        return dfs(i, j - 1, new HashMap<>(map));
                    j++; i = j;
                    j = getRight(i, r);
                    int value = dfs(i, j - 1, new HashMap<>(map));
                    map.put(key, value);
                    i = j + 1;
                }
                return -1; // never
            } else {
                int j = getRight(idx + 1, r);
                int a = dfs(idx + 1, j - 1, new HashMap<>(map)), b = dfs(j + 1, r, new HashMap<>(map));
                return op.equals("add") ? a + b : a * b;
            }
        } else {
            String cur = s.substring(l, r + 1);
            if (map.containsKey(cur)) 
                return map.get(cur);
            return Integer.parseInt(cur);
        }
    }

// 对于 getRight 函数作用，给大家举个例子理解吧，其实就是从 left 出发，找到合法的「子表达式」或「值」为止

// (let x 2 (mult x (let x 3 y 4 (add x y))))
//          a                               b
// 传入 a 返回 b，代表 [a, b) 表达式为 (mult x (let x 3 y 4 (add x y)))

// (let x 2 (mult x (let x 3 y 4 (add x y))))
//      ab
// 传入 a 返回 b，代表 [a, b) 表达式为 x

    int getRight(int left, int end) {
        int right = left, score = 0;
        while (right <= end) {
            if (cs[right] == '(') {
                score++; right++;
            } else if (cs[right] == ')') {
                score--; right++;
            } else if (cs[right] == ' ') {
                if (score == 0) 
                    break;
                right++;
            } else {
                right++;
            }
        }
        return right;
    }
}

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/parse-lisp-expression/solution/by-ac_oier-i7w1/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public class test{
    public static void main(String[] args){
        Solution sol = new Solution();
        String exp = new String("(let x 2 (mult x (let x 3 y 4 (add x y))))");
        sol.evaluate(exp);
    }
}
