import java.util.ArrayList;
import java.util.Stack;

class MinStack {
    private Stack<Integer> datastack;
    private ArrayList<Integer> auxlist;

    /** initialize your data structure here. */
    public MinStack() {
        datastack = new Stack<Integer>();
        auxlist = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        datastack.push(x);
        if (auxlist.size()==0 || x<=auxlist.get(auxlist.size()-1)){
            auxlist.add(x);
        }
    }
    
    public void pop() {
        if (datastack.empty()==false){
            int val = datastack.pop();
            if (val==auxlist.get(auxlist.size()-1)){
                auxlist.remove(auxlist.size()-1);
            }
        }
    }
    
    public int top() {
        return datastack.peek();
    }
    
    public int min() {
        return auxlist.get(auxlist.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

public class test{
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.min());   //--> 返回 -2.
    }
}