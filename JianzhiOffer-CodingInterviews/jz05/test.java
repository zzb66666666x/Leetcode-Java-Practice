class Solution {
    public String replaceSpace(String s) {
        if (s.length() == 0){
            return new String("");
        }
        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i=0; i<s.length(); i++){
            if (arr[i]==' ')
                cnt++;
        }
        char[] output = new char[s.length() + 2*cnt];
        int idx = 0;
        for (int i=0; i<s.length(); i++){
            if (arr[i] == ' '){
                output[idx] = '%';
                output[idx+1] = '2';
                output[idx+2] = '0';
                idx+=3;
            }else{
                output[idx] = arr[i];
                idx++;
            }
        }
        return String.valueOf(output);
    }
}
