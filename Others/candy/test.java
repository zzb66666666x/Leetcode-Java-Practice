import java.lang.Math;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n==1){
            return 1;
        }
        int[] bonus = new int[n];
        for (int i=0; i<n; i++){
            bonus[i] = 0;
        }
        // left to right
        int idx = 0;
        int cnt = 0;
        while (idx < n){
            if (idx < n-1 && ratings[idx+1] < ratings[idx]){
                cnt++;
            }else{
                if (cnt != 0){
                    while (cnt > 0){
                        bonus[idx-cnt] = Math.max(bonus[idx-cnt], cnt);
                        cnt--;
                    }
                }
            }
            idx++;
        }
        // right to left
        idx = n-1;
        cnt = 0;
        while (idx >= 0){
            if (idx > 0 && ratings[idx-1] < ratings[idx]){
                cnt++;
            }else{
                if (cnt != 0){
                    while (cnt > 0){
                        bonus[idx+cnt] = Math.max(bonus[idx+cnt], cnt);
                        cnt--;
                    }
                }
            }
            idx --;
        }
        int sum = n;
        for (int i=0; i<n; i++){
            // System.out.println(bonus[i]+1);
            sum += bonus[i];
        }
        return sum;
    }
}

public class test{
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] arr = new int[]{1,3,2,1,0,1,2,2,2,3};
        sol.candy(arr);
    }
}

// rating 1 2 3 4 2
//         + + + - 
// candy  1 2 3 4 1

// rating 1 3 2 1 0 1 2 2 2 3
//       x + - - - + + = = + x
//        1 4 3 2 1 1 1 1 1 1
//        1 4 3 2 1 2 3 1 1 2
// candy  1 4 3 2 1 2 3 1 1 2