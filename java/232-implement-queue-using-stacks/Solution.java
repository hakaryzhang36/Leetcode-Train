// Leetcode 232-implement-queue-using-stacks
class MyQueue {
    Queue<Integer> input = null; 
    Queue<Integer> output = null; 

    public MyQueue() {
        input = new ArrayDeque<Integer>();
        output = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        input.offer(x);
    }
    
    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.offer(input.poll());
            }
        }
        return output.poll();   
    }
    
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.offer(input.poll());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
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