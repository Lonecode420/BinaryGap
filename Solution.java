import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> longestBinaryGapIndices(int N) {
        List<Integer> maxGapStartIndices = new ArrayList<>();
        int maxGap = 0;
        int currentGap = 0;
        int bitIndex = 0;          // Current bit position (rightmost bit = 0)
        int currentStartIndex = 0; // Start index of current gap
        boolean counting = false;  // Have we hit the first '1'?

        while (N > 0) {
            if ((N & 1) == 1) {
                if (counting) {
                    if (currentGap > maxGap) {
                        maxGap = currentGap;
                        maxGapStartIndices.clear();
                        maxGapStartIndices.add(currentStartIndex);
                    } else if (currentGap == maxGap && currentGap > 0) {
                        maxGapStartIndices.add(currentStartIndex);
                    }
                }
                counting = true;
                currentGap = 0;
                currentStartIndex = bitIndex + 1; // Next zero starts at next bit
            } else {
                if (counting) {
                    currentGap++;
                }
            }
            N >>= 1;
            bitIndex++;
        }

        return maxGapStartIndices;
    }

    // Helper method to print result nicely
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N = 1041; // binary: 10000010001
        List<Integer> indices = sol.longestBinaryGapIndices(N);
        System.out.println("Longest gap start indices: " + indices); // Should print [1]
    }
}
