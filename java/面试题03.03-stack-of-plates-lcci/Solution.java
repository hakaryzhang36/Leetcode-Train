// Leetcode 面试题03.03-stack-of-plates-lcci
class StackOfPlates {
    int cap;
    List<int[]> stackList = new ArrayList<>();

    public StackOfPlates(int cap) {
        this.cap = cap;
        System.out.println(cap);
    }
    
    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (stackList.size() != 0) {
            int[] stack = stackList.get(stackList.size() - 1);
            for (int i = 0; i < cap; i++) {
                if (stack[i] == -1) {
                    stack[i] = val;
                    return;
                }
            }
        }
        // stack full or empty
        int[] newStack = new int[cap];
        for (int i = 0; i < cap; i++) {
            newStack[i] = -1;
        }
        newStack[0] = val;
        stackList.add(newStack);
    }
    
    public int pop() {
        int res = -1;
        System.out.println(stackList.size());
        if (stackList.size() == 0) {
            return res;
        }
        else {
            int[] stack = stackList.get(stackList.size() - 1);
            for (int i = cap - 1; i >= 0; i--) {
                if (stack[i] != -1) {
                    res = stack[i];
                    stack[i] = -1;
                    break;
                }
            }
            // stack empty
            if (stack[0] == -1) {
                stackList.remove(stackList.size() - 1);
            }
        }
        return res;
    }
    
    public int popAt(int index) {
        int res = -1;
        if (index > stackList.size() - 1) {
            return res;
        }
        int[] stack = stackList.get(index);
        for (int i = cap - 1; i >= 0; i--) {
            if (stack[i] != -1) {
                res = stack[i];
                stack[i] = -1;
                break;
            }
        }
        // stack empty
        if (stack[0] == -1) {
            stackList.remove(index);
        }
        return res;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */