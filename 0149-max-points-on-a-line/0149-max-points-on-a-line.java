import java.util.*;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0, vertical = 0, currMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                } else if (dx == 0) {
                    vertical++;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    // Normalize the slope representation
                    String slope = dx + "/" + dy;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                    currMax = Math.max(currMax, slopeMap.get(slope));
                }
            }

            maxPoints = Math.max(maxPoints, Math.max(currMax, vertical) + duplicate + 1);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
