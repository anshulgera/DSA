class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while (!s.empty()) {
            int curr = s.pop();
            while(!temp.empty() && temp.peek() > curr) {
                int top = temp.pop();
                s.push(top);
            }
            temp.push(curr);
        }
        return temp;
    }
}
