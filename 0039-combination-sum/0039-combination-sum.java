import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add a copy of the current list to the result
            return;
        }

        if (target < 0) {
            return; // If the target goes below 0, no need to explore further
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // Include the candidate
            backtrack(candidates, target - candidates[i], i, current, result); // Recur with reduced target
            current.remove(current.size() - 1); // Backtrack by removing the last added element
        }
    }
}
