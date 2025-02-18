import java.util.Stack;

class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1); // Push numbers from 1 to n+1

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                // Pop all elements from the stack when encountering 'I' or at the end
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}
