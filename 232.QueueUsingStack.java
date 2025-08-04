class MyQueue {
    //Creating Reference of stack class
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
       //Creating objects for the references 
       s1 = new Stack<Integer>();
       s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        //Inserting all the elements of stack 1 into stack 2
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        //Inserting the new element into the stack
        s1.push(x);
        //Moving back all the elements from s2 to s1
        while(s2.size()>0){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        if(s1.size()==0) return true;
        return false;
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
