class Solution {
    public int strToInt(String str) {
        char[] cs = str.toCharArray();
        long ans = 0;
        int sign = 1;
        char state = 0;
        for (int i=0; i < cs.length; i++){
            char c = cs[i];
            if (c == ' ' && state == 0){
                continue;
            }else if ((c=='+' || c=='-') && state==0){
                state = 1;
                sign = (c=='+')? 1 : -1;
            }else if (c >= '0' && c <= '9'){
                state=2;
                ans = ans*10 + (int)(c-'0');
                if ((sign > 0 && ans > (long)Integer.MAX_VALUE) || (sign<0 && -ans < (long)Integer.MIN_VALUE)){
                    return (sign>0)? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return sign>0 ? (int)ans : (int)(-ans);
    }
}
