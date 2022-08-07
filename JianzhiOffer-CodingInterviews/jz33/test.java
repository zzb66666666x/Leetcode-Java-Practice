// my code
// class Solution {
//     public boolean verifyPostorder(int[] postorder) {
//         if(postorder == null)
//             return true;
//         return check(postorder, 0, postorder.length-1, 0, 0);
//     }

//     private boolean check(int[] p, int L, int R, int numLimit, int dir){
//         if (L>=R)
//             return true;
//         int rootval = p[R];
//         int[] ret = search(p, rootval, L, R-1);
//         if (ret[0] >=0 && ret[1] >=0){
//             if (ret[0] >= ret[1])
//                 return false;
//             if (dir < 0 && p[ret[1]] > numLimit){
//                 return false;
//             }
//             if (dir > 0 && p[ret[0]] < numLimit){
//                 return false;
//             }
//             return check(p, L, ret[0], rootval, -1) && check(p, ret[0]+1, ret[1], rootval, 1);
//         }else if (ret[0] >= 0){// check left subtree only
//             if (dir > 0 && p[ret[0]] < numLimit){
//                 return false;
//             }
//             return check(p, L, ret[0], rootval, -1);
//         }else if (ret[1] >= 0){// check right subtree only
//             if (dir < 0 && p[ret[1]] > numLimit){
//                 return false;
//             }
//             return check(p, L, ret[1], rootval, 1);
//         }else{
//             System.out.println("something wrong");
//             return false;
//         }
//     }

//     private int[] search(int[] nums, int val, int L, int R){
//         int[] ret = new int[]{-1, -1}; // [0]: smaller than [1]: larger than
//         for (int i = R; i>=L; i--){
//             if (ret[0] != -1 && ret[1] != -1)
//                 break;
//             if (ret[1] == -1 && nums[i] > val){
//                 ret[1] = i;
//             }
//             if (ret[0] == -1 && nums[i] < val){
//                 ret[0] = i;
//             }
//         }
//         return ret;
//     }
// }

// same algorithm, but cleaner
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

// 作者：jyd
// 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
