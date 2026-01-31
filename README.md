# BinaryGap
Classic binary gap problem
Problem Understanding
We are given a positive integer N.
A binary gap is defined as:
A sequence of consecutive zeros (0)
That is surrounded by ones (1) on both sides
In the binary representation of N

Examples

N = 1041 → Binary: 10000010001 → Longest gap = 5
N = 32 → Binary: 100000 → No closing 1 → 0

If no valid binary gap exists, return 0.

💡 Key Insight

A binary gap:
Can only start after the first 1
Must end at another 1
Trailing zeros do not count
We can process the number bit by bit, without converting it to a string.

🛠️ Algorithm (Bit Manipulation)

Traverse the bits of N from right to left
Ignore zeros until we encounter the first 1
Once counting starts:
Increment a counter for every 0

When a 1 appears:

Update the maximum gap

Reset the zero counter

Continue until all bits are processed

✅ Correctness Proof (Why this works)

We only start counting zeros after the first 1, ensuring the gap is left-bounded
We only update the result when we encounter another 1, ensuring the gap is right-bounded
Trailing zeros are ignored automatically, since no closing 1 appears
Every valid binary gap is considered exactly once
Thus, the algorithm always returns the length of the longest valid binary gap.

⏱️ Complexity Analysis

Time Complexity: O(log N)
We process each bit of N once

Space Complexity: O(1)
Only a few integer variables are used

Approach

Traverse N bit by bit (rightmost bit = index 0).

Track:

currentGap length
currentStartIndex of the gap
maxGap found so far
List of maxGapStartIndices

When we hit a 1:

If currentGap > maxGap → reset list, update max, add start index

If currentGap == maxGap → append start index

Shift N right and increment index

This handles:

Multiple gaps of the same max length
Trailing zeros automatically ignored
