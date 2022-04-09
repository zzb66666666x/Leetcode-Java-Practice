class MyStack{
    private int stack[];
    private int head;
    private int max_len;

    public MyStack(int param_max_len){
        max_len = param_max_len;
        stack = new int[max_len];
        head = -1;
    }

    public int push(int value){
        if (head >= max_len-1){
            return -1;
        }
        stack[head+1] = value;
        head++;
        return 0;
    }

    public int pop(){
        if (head < 0){
            return -1;
        }
        int ret = stack[head];
        head --;
        return ret;
    }

    public int empty(){
        if (head < 0){
            return 1;
        }
        return 0;
    }
}

class CQueue {
    private MyStack stack_in;
    private MyStack stack_out;
    private int max_len;

    private int dump(){
        while (stack_in.empty()==0){
            int val = stack_in.pop();
            int ret = stack_out.push(val);
            if (ret < 0){
                return -1;
            }
        }
        return 0;
    }


    public CQueue() {
        max_len = 10000;
        stack_in = new MyStack(max_len);
        stack_out = new MyStack(max_len);
    }
    
    public void appendTail(int value) {
        stack_in.push(value);
    }
    
    public int deleteHead() {
        if (stack_out.empty() == 1){
            dump();
        }
        return stack_out.pop();
    }
}

public class test{
    public static void main(String[] args){
        CQueue obj = new CQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
        int param_3 = obj.deleteHead();
        System.out.println(param_3);
        int param_4 = obj.deleteHead();
        System.out.println(param_4);
    }
}