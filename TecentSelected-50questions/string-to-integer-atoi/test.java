class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if (n==0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int idx = 0;
        while (idx < n){
            if (charArray[idx] == ' '){
                idx ++;
            }else{
                break;
            }
        }
        if (idx == n){
            return 0;
        }
        int sign = 1;
        if (charArray[idx] == '-'){
            sign = -1;
            idx ++;
        }else if (charArray[idx] == '+'){
            idx++;
        }
        int res = 0;
        while (idx < n){
            char c = charArray[idx];
            if (c < '0' || c > '9'){
                break;
            }
            int val = (int)(c - '0');
            if (res == 0){
                res = val * sign;
                idx++;
                continue;
            }
            if (sign == 1 && res > Integer.MAX_VALUE / 10){
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res < Integer.MIN_VALUE / 10){
                return Integer.MIN_VALUE;
            }
            res = 10 * res;
            // detect overflow
            int res_sign = (res > 0)? 1 : -1;
            int temp = res + (sign * val);
            int temp_sign = (temp > 0)? 1 : -1;
            if (temp_sign == res_sign){
                res = temp;
            }else{
                res = (res_sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            idx++;
        }
        return res;
    }
}

public class test{
    public static void main(String[] s){
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("2147483649"));
    }
}