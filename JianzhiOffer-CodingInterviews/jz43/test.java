class Solution {
    public int countDigitOne(int n) {
        // 2147483647 -> length=10
        // System.out.println(Integer.MAX_VALUE);
        String str = Integer.toString(n);
        int nonzeros = str.length();
        int[] cnt = new int[nonzeros];
        for (int i=1; i<nonzeros; i++){
            cnt[i] = 10 * cnt[i-1] + (int)Math.pow(10, i-1);
        }
        int ret = cnt[cnt.length-1];
        // for (int i=0; i<cnt.length; i++){
        //     System.out.printf("%d ", cnt[i]);
        // }
        // System.out.println();
        // System.out.println(ret);
        return ret+helper(cnt, str, n, 0);
    }

    private int helper(int[] cnt, String str, int n, int idx){
        if (idx >= str.length()){
            return 0;
        }
        int weight = cnt.length - idx - 1;
        // System.out.println(weight);
        int digit = (int)(str.charAt(idx) - '0');
        int ret = 0;
        for (int i=0; i<=digit; i++){
            if (idx == 0 && i==0)
                continue;
            if (i==digit){
                if (i==1){
                    return n - curMin(str, idx) + 1 + helper(cnt, str, n, idx+1) + ret;
                }else{
                    return helper(cnt, str, n, idx+1) + ret;
                }
            }else{
                ret += (i==1 ? cnt[weight] + (int)Math.pow(10, weight) : cnt[weight]);
            }
        }
        return 0;
    }

    private int curMin(String str, int idx){
        char[] cs = new char[str.length()];
        for (int i=0; i<str.length(); i++){
            if (i<=idx){
                cs[i] = str.charAt(i);
            }else{
                cs[i] = '0';
            }
        }
        String newstr = new String(cs);
        return Integer.valueOf(newstr);
    }
}
