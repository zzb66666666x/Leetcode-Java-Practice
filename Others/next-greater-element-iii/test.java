class Solution {
    private int sol = -1;

    private void swap(char[] arr, int a, int b){
        if (a==b)
            return;
        char tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
    }

    private void perm(char[] arr, int start, int end, int n){
        if (start == end){
            String s = String.valueOf(arr);
            // int val = Integer.parseInt(s);
            long val = Long.parseLong(s);
            if (val > Integer.MAX_VALUE)
                return;
            if (val > n && (sol == -1 || val < sol)){
                sol = (int)val;
            }
        }
        for (int i=start; i<=end; i++){
            swap(arr, start, i);
            perm(arr, start+1, end, n);
            swap(arr, start, i);
        }
    }

    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        char[] charArray = s.toCharArray();
        // get permutation
        perm(charArray, 0, s.length()-1, n);
        return sol;
    }
}

public class test{
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.nextGreaterElement(Integer.MAX_VALUE));
    }
}