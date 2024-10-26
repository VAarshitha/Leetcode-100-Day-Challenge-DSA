import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Step 1: Create a map of Roman symbols and their values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Step 2: Initialize a variable to store the result
        int result = 0;

        // Step 3: Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));

            // Step 4: Check if the current value is smaller than the next value
            if (i < s.length() - 1 && current < romanMap.get(s.charAt(i + 1))) {
                // Subtract current value if it's smaller than the next one
                result -= current;
            } else {
                // Otherwise, add the current value
                result += current;
            }
        }

        // Step 5: Return the final result
        return result;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test the method with different inputs
        System.out.println(solution.romanToInt("III"));     // Output: 3
        System.out.println(solution.romanToInt("IV"));      // Output: 4
        System.out.println(solution.romanToInt("IX"));      // Output: 9
        System.out.println(solution.romanToInt("LVIII"));   // Output: 58
        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994
    }
}
