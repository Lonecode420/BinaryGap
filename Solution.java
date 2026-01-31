import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Returns the list of starting indices of the longest binary gaps
    public static List<Integer> longestBinaryGapIndices(int N) {
        List<Integer> maxGapStartIndices = new ArrayList<>();
        int maxGap = 0;
        int currentGap = 0;
        int bitIndex = 0;          // Rightmost bit = 0
        int currentStartIndex = 0; // Start index of current gap
        boolean counting = false;  // Have we seen the first '1'?

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
                currentStartIndex = bitIndex + 1; // Next gap starts at next bit
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

    // Helper to get binary representation as string
    public static String toBinaryString(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            sb.insert(0, (N & 1));
            N >>= 1;
        }
        return sb.toString();
    }

    // Main method
    public static void main(String[] args) {
        int N = 1041; // Example number
        System.out.println("Number: " + N);
        System.out.println("Binary: " + toBinaryString(N));

        List<Integer> indices = longestBinaryGapIndices(N);
        System.out.println("Longest gap start indices: " + indices);
    }
}

