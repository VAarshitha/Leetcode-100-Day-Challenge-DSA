import java.util.Stack;

public class Solution { // Renamed the class to Solution
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;  // 1 represents '+', -1 represents '-'
        int currentNumber = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the current number
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+') {
                // Add current number to result based on the sign
                result += sign * currentNumber;
                currentNumber = 0;
                sign = 1; // Update sign to positive
            } else if (c == '-') {
                // Add current number to result based on the sign
                result += sign * currentNumber;
                currentNumber = 0;
                sign = -1; // Update sign to negative
            } else if (c == '(') {
                // Push the current result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Add the current number to the result
                result += sign * currentNumber;
                currentNumber = 0;
                // Pop sign and previous result from the stack
                result *= stack.pop(); // Apply the sign
                result += stack.pop(); // Add the previous result
            }
        }
        // Add the last number to the result
        result += sign * currentNumber;
        return result;
    }
}
