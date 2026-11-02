// class Solution {
//     public int trap(int[] height) {
//         int best = 0;                          // total water (starts at 0)

//         for (int i = 0; i < height.length; i++) {

//             int leftMax = 0;                   // reset for every i
//             for (int j = 0; j <= i; j++) {     // look at bars from 0 to i
//                 leftMax = Math.max(leftMax, height[j]);
//             }

//             int rightMax = 0;                  // reset for every i
//             for (int j = i; j < height.length; j++) {   // look at bars from i to the end
//                 rightMax = Math.max(rightMax, height[j]);
//             }

//             best = best + Math.min(leftMax, rightMax) - height[i];   // water above bar i
//         }
//         return best;
//     }
// }
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Pass 1: left to right
        // leftMax[i] = tallest bar from index 0 to i
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Pass 2: right to left
        // rightMax[i] = tallest bar from index i to the end
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Pass 3: add up the water above every bar
        int best = 0;
        for (int i = 0; i < n; i++) {
            best = best + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return best;
    }
}