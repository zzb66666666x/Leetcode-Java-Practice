class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null)
            return true;
        return check(postorder, 0, postorder.length-1, 0, 0);
    }

    private boolean check(int[] p, int L, int R, int numLimit, int dir){
        if (L>=R)
            return true;
        int rootval = p[R];
        int[] ret = search(p, rootval, L, R-1);
        if (ret[0] >=0 && ret[1] >=0){
            if (ret[0] >= ret[1])
                return false;
            if (dir < 0 && p[ret[1]] > numLimit){
                return false;
            }
            if (dir > 0 && p[ret[0]] < numLimit){
                return false;
            }
            return check(p, L, ret[0], rootval, -1) && check(p, ret[0]+1, ret[1], rootval, 1);
        }else if (ret[0] >= 0){// check left subtree only
            if (dir > 0 && p[ret[0]] < numLimit){
                return false;
            }
            return check(p, L, ret[0], rootval, -1);
        }else if (ret[1] >= 0){// check right subtree only
            if (dir < 0 && p[ret[1]] > numLimit){
                return false;
            }
            return check(p, L, ret[1], rootval, 1);
        }else{
            System.out.println("something wrong");
            return false;
        }
    }

    private int[] search(int[] nums, int val, int L, int R){
        int[] ret = new int[]{-1, -1}; // [0]: smaller than [1]: larger than
        for (int i = R; i>=L; i--){
            if (ret[0] != -1 && ret[1] != -1)
                break;
            if (ret[1] == -1 && nums[i] > val){
                ret[1] = i;
            }
            if (ret[0] == -1 && nums[i] < val){
                ret[0] = i;
            }
        }
        return ret;
    }
}
