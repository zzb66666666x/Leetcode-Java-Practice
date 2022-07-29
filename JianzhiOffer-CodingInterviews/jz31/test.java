class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        if (n==0)
            return true;
        Stack<Integer> s = new Stack<>();
        int idx1 = 0; int idx2 = 0;
        while (idx2<n){
            if (s.size() == 0){
                if (idx1 > n-1)
                    return false;
                s.push(pushed[idx1++]);
                continue;
            }
            if (s.peek() == popped[idx2]){
                s.pop();
                idx2++;
            }else{
                if (idx1 > n-1)
                    return false;
                s.push(pushed[idx1++]);
            }
        }
        return true;
    }
}
