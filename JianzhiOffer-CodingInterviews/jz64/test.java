class Solution {
    public int sumNums(int n) {
        int sum=0;
        boolean foo = (n>0) && ((sum = n+sumNums(n-1)) > 0);
        return sum;
    }
}
