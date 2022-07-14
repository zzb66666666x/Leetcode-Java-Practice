class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        chars.put(s.charAt(0), 0);
        int maxval = 0;
        for (int i=1; i<n; i++){
            char c = s.charAt(i);
            if (chars.containsKey(c)){
                if (c == s.charAt(i-1)){
                    dp[i] = 1;
                    chars = new HashMap<Character, Integer>();
                }else{
                    int idx = chars.get(c);
                    dp[i] = i-idx;
                    chars = new HashMap<Character, Integer>();
                    for (;idx<i; idx++){
                        chars.put(s.charAt(idx), idx);
                    }
                }
                chars.put(c, i);
            }else{
                dp[i] = dp[i-1]+1;
                chars.put(c, i);
            }
            if (dp[i]>maxval)
                maxval = dp[i];
        }
        return maxval;
    }
}
