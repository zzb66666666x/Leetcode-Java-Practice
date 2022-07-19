class Solution {
    public String reverseWords(String s) {
        ArrayList<String> ss = new ArrayList<String>();
        s += " ";
        char state = '0';
        int begin = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                if (state == '0'){
                    continue;
                }else{
                    state = '0';
                    ss.add(s.substring(begin, i));
                }
            }else{
                if (state == '0'){
                    state = 'r';
                    begin = i;
                }else{
                    continue;
                }
            }
        }
        String output = "";
        for (int i=ss.size()-1; i>=0; i--){
            output += (ss.get(i));
            if (i!=0)
                output += " ";
        }
        return output;
    }
}
