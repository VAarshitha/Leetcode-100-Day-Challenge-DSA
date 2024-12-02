import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go up to the parent directory
                }
            } else if (!part.equals("") && !part.equals(".")) {
                stack.push(part); // Add the directory to the stack
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/home/../usr//bin/./";
        System.out.println(solution.simplifyPath(path)); // Output: "/usr/bin"
    }
}
