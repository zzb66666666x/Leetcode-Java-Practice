// dp
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] ret = new int[n];
        int product = 1;
        for (int i=0; i<n; i++){
            ret[i] = product;
            product *= a[i];
        }
        product = 1; 
        for (int i=n-1; i>=0; i--){
            ret[i] *= product;
            product *= a[i];
        }
        return ret;
    }
}
