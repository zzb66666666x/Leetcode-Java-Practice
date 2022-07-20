class MedianFinder {
    private PriorityQueue<Integer> maxq = null;
    private PriorityQueue<Integer> minq = null;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxq = new PriorityQueue<Integer>((v1, v2)->(v2-v1));
        minq = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        int maxqsize = maxq.size();
        int minqsize = minq.size();
        if (minqsize > maxqsize){
            System.out.println("ERROR IN MedianFinder Queue Size");
            System.exit(1);
        }
        if (maxqsize == 0){
            maxq.offer(num);
            return;
        }
        if (minqsize == 0){
            if (num >= maxq.peek()){
                minq.offer(num);
            }else{  
                maxq.offer(num);
                int head = maxq.poll();
                minq.offer(head);
            }
            return;
        }
        if (num < maxq.peek()){
            if (maxqsize > minqsize){
                maxq.offer(num);
                int head = maxq.poll();
                minq.offer(head);
            }else{
                maxq.offer(num);
            }
        }else if(num > minq.peek()){
            if (maxqsize > minqsize){
                minq.offer(num);
            }else{
                minq.offer(num);
                int head = minq.poll();
                maxq.offer(head);
            }
        }else{
            if (maxqsize == minqsize){
                maxq.offer(num);
            }else{
                minq.offer(num);
            }
        }
    }
    
    public double findMedian() {
        int maxqsize = maxq.size();
        int minqsize = minq.size();
        // System.out.println("size "+maxqsize + " : "+minqsize);
        // System.out.println("head "+maxq.peek() + " : "+minq.peek());
        if (maxqsize + minqsize == 0)
            System.exit(1); 
        if ((maxqsize + minqsize)%2 != 0){
            return (double)maxq.peek();
        }else{
            return (maxq.peek() + minq.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
