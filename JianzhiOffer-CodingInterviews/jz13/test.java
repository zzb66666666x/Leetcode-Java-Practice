class Solution {
    class Pair{
        public int r;
        public int c;
        public Pair(int row, int col){
            r = row;
            c = col;
        }
    }

    private int m;
    private int n;
    private int k;

    public int movingCount(int m, int n, int k) {
        int sum = 0;
        this.m = m;
        this.n = n;
        this.k = k;
        LinkedList<Pair> q = new LinkedList<Pair>();
        char[][] record = new char[m][n];
        addQueue(record, q, 0, 0);
        while (q.isEmpty() == false){
            Pair p = q.getFirst();
            sum++;
            addQueue(record, q, p.r+1, p.c);
            addQueue(record, q, p.r, p.c+1);
            addQueue(record, q, p.r-1, p.c);
            addQueue(record, q, p.r, p.c-1);
            q.removeFirst();
        }
        return sum;
    }

    private void addQueue(char[][] record, LinkedList<Pair> q, int r, int c){
        if (r>=m || r<0 || c>=n || c<0)
            return;
        if (getDigitSum(r) + getDigitSum(c) > k)
            return;
        if (record[r][c] == '1')
            return;
        record[r][c] = '1';
        q.add(new Pair(r, c));
    }

    private int getDigitSum(int x){
        String s = Integer.toString(x);
        int sum = 0;
        for (int i=0; i<s.length(); i++){
            sum += (int)(s.charAt(i) - '0');
        }
        return sum;
    }
}
