// 时间爆炸的递归算法，因为check函数产出的branch太多导致时间超了
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         char[] cs1 = s1.toCharArray();
//         char[] cs2 = s2.toCharArray();
//         char[] cs3 = s3.toCharArray();
//         if (cs1.length + cs2.length != cs3.length)
//             return false;
//         if ((s1.equals(s3) && s2.equals("")) || (s2.equals(s3) && s1.equals("")))
//             return true;
//         return check(cs1, cs2, cs3, 0 ,0, 0);
//     }

//     private boolean check(char[] cs1, char[] cs2, char[] cs3, int idx1, int idx2, int idx3){
//         while(idx3 < cs3.length){
//             char c1 = '0';
//             char c2 = '0';
//             char c3 = cs3[idx3];
//             if (idx1 < cs1.length)
//                 c1 = cs1[idx1];
//             if (idx2 < cs2.length)
//                 c2 = cs2[idx2];
//             if(c1 == c3 && c2 != c3){
//                 idx1++;
//                 idx3++;
//             }else if (c1 != c3 && c2 == c3){
//                 idx2++;
//                 idx3++;
//             }else if (c1 == c3 && c2 == c3){
//                 if(check(cs1, cs2, cs3, idx1+1, idx2, idx3+1)){
//                     return true;
//                 }else{
//                     return check(cs1, cs2, cs3, idx1, idx2+1, idx3+1);
//                 }
//             }else {
//                 return false;
//             }
//         }
//         if (idx1 == cs1.length && idx2 == cs2.length && idx3 == cs3.length){
//             return true;
//         }else{
//             return false;
//         }
//     }
// }

// 采用dp，让检测有记忆性
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
