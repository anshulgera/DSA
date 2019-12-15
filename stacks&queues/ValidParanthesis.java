// idea - when encountering an opening paranthesis, push closing paranthesis
// when encountering closing parathesis check if stack is empty, if not the char should be equal 
// to stack top else false
// if valid paranthesis, at end stack should be empty

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '['){
                stack.push(']');
            } else if(stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
        
    }
}


// ------------------------------------------------------
class Solution {
    public boolean isValid(String s) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(curr == '(') {
                countA++;
                stack.push(curr);
            } else if(curr == '{') {
                countB++;
                stack.push(curr);
            } else if(curr == '[') {
                countC++;
                stack.push(curr);
            } else if(curr == ')') {
                if(countA <= 0 || stack.peek() != '(') return false;
                stack.pop();
                countA--;
            } else if(curr == '}') {
                if(countB <= 0 || stack.peek() != '{') return false;
                stack.pop();
                countB--;
            } else if(curr == ']') {
                if(countC <= 0 || stack.peek() != '[') return false;
                stack.pop();
                countC--;
            }
        }
        if(countA > 0 || countB > 0 || countC > 0) return false;
        return true;
        
    }
}