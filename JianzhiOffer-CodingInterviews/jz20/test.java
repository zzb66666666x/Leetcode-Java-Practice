class Solution {
    public boolean isNumber(String s) {
        int epos = -1;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='E' || s.charAt(i) == 'e'){
                if (epos < 0 && i>0){
                    epos = i;
                }else{
                    return false;
                }
            }
        }
        if (epos > 0){
            return checkDigit(s.substring(0, epos), true, false, true) && checkDigit(s.substring(epos+1, s.length()), false, true, false);
        }else{
            return checkDigit(s, true, true, true);
        }
    }

    private boolean checkDigit(String s, boolean allowHeadBlank, boolean allowEndBlank, boolean allowFloat){
        // System.out.println(s);
        int state=0; // 0: init, 1: has sign, 2: reading digit (int/float)
        boolean isFloat = false;
        boolean hasFrontDigit = false;
        boolean hasEndDigit = false;
        boolean reachedEnd = false;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c != ' ' && reachedEnd){
                return false;
            }else if (c==' ' && state==0){
                if (allowHeadBlank && !isFloat){
                    continue;
                }else{
                    return false;
                }
            }else if (c==' ' && state==2){
                if (allowEndBlank){
                    reachedEnd = true;
                    continue;
                }else{
                    return false;
                }
            }else if ((c=='+' || c=='-') && state==0 && !isFloat){
                state = 1;
            }else if (c=='.' && !isFloat){
                isFloat = true;
                if (!allowFloat)
                    return false;
            }else if (c>='0' && c<='9'){
                state = 2;
                if (isFloat){
                    hasEndDigit = true;
                }else{
                    hasFrontDigit = true;
                }
            }else{
                return false;
            }
        }
        if (isFloat){
            return hasFrontDigit || hasEndDigit;
        }else{
            return hasFrontDigit;
        }
    }
}
