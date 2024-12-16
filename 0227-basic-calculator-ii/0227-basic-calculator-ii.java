import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';  // Initialize with '+' to handle the first number

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a digit, build the number
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            // If the current character is an operator or the end of the string
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                // Update operation and reset currentNumber
                operation = c;
                currentNumber = 0;
            }
        }

        // Sum all the values in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "3+2*2";
        System.out.println(solution.calculate(expression)); // Output: 7
    }
}
