class MaxQueue {
    ArrayDeque<Integer> q;
    ArrayDeque<Integer> help;

    public MaxQueue() {
        q = new ArrayDeque<Integer>();
        help = new ArrayDeque<Integer>();
    }
    
    public int max_value() {
        if (!q.isEmpty()){
            return help.peek();
        }else{
            return -1;
        }
    }
    
    public void push_back(int value) {
        q.offer(value);
        while(!help.isEmpty() && value>help.peekLast()){
            help.pollLast();
        }
        help.offer(value);
    }
    
    public int pop_front() {
        if (q.isEmpty())
            return -1;
        int ret = q.poll();
        if(ret == help.peek()){
            help.poll();
        }
        return ret;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
