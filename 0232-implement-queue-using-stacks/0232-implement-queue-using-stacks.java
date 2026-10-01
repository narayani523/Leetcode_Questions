class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void shift(){
        if(!s2.isEmpty()){
            return;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        shift();
        if(s2.isEmpty()){
            return -1;
        }
        int front=s2.peek();
        s2.pop();
        return front;
    }
    
    public int peek() {
        shift();
        if(s2.isEmpty()){
            return -1;
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */