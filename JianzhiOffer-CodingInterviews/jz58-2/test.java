class Solution {
    public String reverseLeftWords(String s, int n) {
        if(s.equals("")){
            return new String("");
        }
        char[] arr = s.toCharArray();
        char[] output = new char[arr.length]; 
        int idx=0;
        for (int i=n; i<arr.length; i++){
            output[idx] = arr[i];
            idx++;
        }
        for (int i=0; i<n; i++){
            output[idx] = arr[i];
            idx++;
        }
        return String.valueOf(output);
    }
}
