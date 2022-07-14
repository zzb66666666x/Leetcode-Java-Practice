
class WordFilter {
    class TrieNode{
        TrieNode[] tns = new TrieNode[26];
        ArrayList<Integer> idxs = new ArrayList<Integer>();
    }

    private TrieNode tr1 = null;
    private TrieNode tr2 = null;

    public WordFilter(String[] words) {
        tr1 = new TrieNode();
        tr2 = new TrieNode();
        for (int i=0; i<words.length; i++){
            add(tr1, words[i], i, false);
            add(tr2, words[i], i, true);
        }
    }
    
    public int f(String pref, String suff) {
        int n = pref.length();
        int m = suff.length();
        TrieNode p = tr1;
        for (int i=0; i<n; i++){
            int cidx = (int)(pref.charAt(i) - 'a');
            if (p.tns[cidx] == null)
                return -1;
            p = p.tns[cidx];
        }
        ArrayList<Integer> l1 = p.idxs;
        p = tr2;
        for (int i=m-1; i>=0; i--){
            int cidx = (int)(suff.charAt(i) - 'a');
            if (p.tns[cidx] == null)
                return -1;
            p = p.tns[cidx];
        }
        ArrayList<Integer> l2 = p.idxs;
        n = l1.size();
        m = l2.size();
        for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
            if (l1.get(i) > l2.get(j)) i--;
            else if (l1.get(i) < l2.get(j)) j--;
            else return l1.get(i);
        }
        return -1;
    }

    private void add(TrieNode node, String s, int stridx, boolean isTurn){
        int n = s.length();
        node.idxs.add(stridx);
        for (int i = isTurn? n-1:0; i>=0 && i<n; i += (isTurn? -1 : 1)){
            char c = s.charAt(i);
            int cidx = (int)(c-'a');
            if (node.tns[cidx] == null)
                node.tns[cidx] = new TrieNode();
            node = node.tns[cidx];
            node.idxs.add(stridx);
        }
    }

    private void printlist(ArrayList<Integer> l){
        System.out.println("printlist");
        for (int i=0; i<l.size(); i++){
            System.out.printf("%d ", l.get(i));
        }
        System.out.printf("\n");
    }
}
