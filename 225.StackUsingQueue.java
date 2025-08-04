class MyStack {
    //Creating references of Queue class as MainQueue and SupportingQueue.
    Queue<Integer> mq;
    Queue<Integer> sq;
    public MyStack() {
        //Creating objects 
        mq = new LinkedList<Integer>();
        sq = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        //The main logic lies here 
        if(mq.size()==0 && sq.size()==0){
            mq.add(x);
        }
        else{
            //Move all the elements of mq to sq
            while(mq.size()>0){
                int ele = mq.remove();
                sq.add(ele);
            }
            //mq is now empty
            mq.add(x);
            //Move back all the elements from the sq to mq
            while(sq.size()>0){
                int ele = sq.remove();
                mq.add(ele);
            }
        }
    }
    
    public int pop() {
        return mq.remove();
    }
    
    public int top() {
        return mq.peek();
    }
    
    public boolean empty() {
        if(mq.size()==0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
