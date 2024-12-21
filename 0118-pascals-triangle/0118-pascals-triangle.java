import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case: First row is always [1]
        if (numRows == 0) return triangle;

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        // Build the triangle row by row
        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            currentRow.add(1); // First element
            
            // Calculate the intermediate elements
            for (int j = 1; j < row; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            currentRow.add(1); // Last element
            triangle.add(currentRow);
        }
        
        return triangle;
    }
}
