import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        HashSet<Character> repeat = new HashSet<Character>();
        char[] cs = s.toCharArray();
        for (int i=0; i<cs.length; i++){
            char c = cs[i];
            if (repeat.contains(c)){
                continue;
            }
            if (m.containsKey(c)){
                m.remove(c);
                repeat.add(c);
            }else{
                m.put(c, i);
            }
        }
        char ret = ' ';
        int idx = Integer.MAX_VALUE;
        Iterator<Character> iterator = m.keySet().iterator();
        while (iterator.hasNext()) {
            char key = iterator.next();
            int keyidx = m.get(key);
            if (keyidx < idx){
                ret = key;
                idx = keyidx;
            }
        }
        return ret;
    }
}

