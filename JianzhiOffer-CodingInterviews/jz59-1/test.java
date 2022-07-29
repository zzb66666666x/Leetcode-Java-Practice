class Solution {
    ArrayDeque<Integer> queue;
    ArrayDeque<Integer> help;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k==0)
            return new int[0];
        queue = new ArrayDeque<Integer>();
        help = new ArrayDeque<Integer>();
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (idx < k){
            pushback(nums[idx++]);
        }
        while (idx <= nums.length-1){
            list.add(maxval());
            pushback(nums[idx++]);
            popfront();
        }
        list.add(maxval());
        int[] ret = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void pushback(int value){
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()){
            help.pollLast();
        }
        help.offer(value);
    }

    private void popfront(){
        int popval = queue.poll();
        if (help.peek() == popval){
            help.poll();
        }
    }

    private int maxval(){
        return help.peek();
    }
}
