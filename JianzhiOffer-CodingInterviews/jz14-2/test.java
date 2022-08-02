class Solution {
    public int cuttingRope(int n) {
        if (n<=3)
            return n-1;
        int res = n/3;
        int mod3 = n % 3;
        if (mod3 == 1){
            return (int)((pow(3, res-1) * 4) % 1000000007);
        }   
        if (mod3 == 2){
            return (int)((pow(3, res) * 2) % 1000000007);
        }
        // System.out.println("perfectly divided by 3");
        return (int)pow(3, res);
    }

    private long pow(int x, int y){
        long ret = 1;
        while (y > 0){
            ret = (ret * x) % 1000000007;
            y--;
        }
        return ret;
    }
}
