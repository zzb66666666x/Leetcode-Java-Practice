class Solution {
    Set<String> ans;
    private void swap(char[] cs, int a, int b){
        if (a==b)
            return;
        char tmp = cs[a];
        cs[a] = cs[b];
        cs[b] = tmp;
    }

    private void recur(char[] cs, int left, int right){
        if (left == right){
            String newstr = new String(cs);
            ans.add(newstr);
            // System.out.println(newstr);
        }
        for (int i=left; i<=right; i++){
            swap(cs, left, i);
            recur(cs, left+1, right);
            swap(cs, left, i);
        }
    }

    public String[] permutation(String s) {
        if (s.length()==1)
            return new String[]{s};
        ans = new HashSet<String>();
        recur(s.toCharArray(), 0, s.length()-1);
        String[] ret = new String[ans.size()]; int idx=0;
        for (String mystr : ans){
            ret[idx++] = mystr;
        }
        return ret;
    }
}
