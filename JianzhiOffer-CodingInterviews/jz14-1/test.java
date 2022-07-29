class Solution {
    public int cuttingRope(int n) {
        if (n <= 3){
            return n-1;
        }
        int num3 = n / 3;
        int mod3 = n % 3;
        if (mod3 == 1) return (int)Math.pow(3, num3-1) * 4;
        if (mod3 == 2) return (int)Math.pow(3, num3) * 2;
        return (int)Math.pow(3, num3);
    }
}
