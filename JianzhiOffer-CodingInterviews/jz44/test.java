class Solution {
    public int findNthDigit(int n) {
        int numDigit = 1;
        long maxIdx = 9;
        long minIdx = 0;
        long rangeSize = 10;
        while (maxIdx < n){
            numDigit++;
            rangeSize = (long)(Math.pow(10, numDigit) - Math.pow(10, numDigit-1)) * numDigit;
            minIdx = maxIdx+1;
            maxIdx = maxIdx + rangeSize;
        }
        long offset = n - minIdx;
        long whichVal = offset / numDigit;
        long whichDigit = offset % numDigit;
        // System.out.println(whichVal);
        long startVal = numDigit == 1 ? 0 :(long)Math.pow(10, numDigit-1);
        long targetVal = whichVal + startVal;
        String str = Long.toString(targetVal);
        return (int)(str.charAt((int)whichDigit) - '0');
    }
}
