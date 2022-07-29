class Solution {
    public int add(int a, int b) {
        int ret = 0;
        int c = 0;
        for (int n=0; n<32; n++){
            int mask = 1<<n;
            int ain = a & mask;
            int bin = b & mask;
            int s = ain ^ bin ^ c;
            ret |= s;
            c = ((ain & bin) | (ain & c) | (bin & c)) << 1; 
        }
        return ret;
    }
}
