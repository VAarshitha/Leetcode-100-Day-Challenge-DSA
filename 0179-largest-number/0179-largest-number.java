import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings for custom sorting
        String[] strNums = Arrays.stream(nums)
                                 .mapToObj(String::valueOf)
                                 .toArray(String[]::new);
        
        // Sort using custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Join sorted strings to form the largest number
        return String.join("", strNums);
    }
}
