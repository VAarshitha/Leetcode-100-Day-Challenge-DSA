import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        // If the input is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // Map of digit to corresponding letters
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // List to store all the combinations
        List<String> result = new ArrayList<>();
        // Start backtracking
        backtrack(result, new StringBuilder(), digits, mapping, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, String[] mapping, int index) {
        // If the current combination is of the same length as digits, add it to result
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the current digit
        char digit = digits.charAt(index);
        // Get the letters that the current digit can map to
        String letters = mapping[digit - '0'];

        // Explore each letter and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Choose the letter
            backtrack(result, current, digits, mapping, index + 1);  // Recurse for the next digit
            current.deleteCharAt(current.length() - 1);  // Backtrack (remove last letter)
        }
    }
}
