class MinStack {

    Stack<Integer> s;
    Stack<Integer> smin;
    int top;
    int mini;
    int lastMini;

    public MinStack() {
        s = new Stack<>();
        smin = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(smin.isEmpty()){
            smin.push(val);
        } else if(val <= smin.peek()){
            smin.push(val);
        } else {
            smin.push(smin.peek());
        }
        
    }
    
    public void pop() {
        s.pop();
        smin.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return smin.peek();
    }
}