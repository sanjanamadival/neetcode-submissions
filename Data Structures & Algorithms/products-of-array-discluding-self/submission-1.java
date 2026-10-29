// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int b = nums.length;
//         int a[] = new int[b];
//         for (int i = 0; i < nums.length; i++) {
//             int c = 1;
//             for (int j = 0; j < nums.length; j++) {
//                 if (i != j) {
//                     c *= nums[j];
//                 }
//                 a[i]=c;
//             }
//         }
//         return a;
//     }
// }
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];

        // Pass 1: left to right
        // a[i] = product of everything to the left of i
        int left = 1;
        for (int i = 0; i < n; i++) {
            a[i] = left;          // store first
            left = left * nums[i];  // then include nums[i] for the next position
        }

        // Pass 2: right to left
        // multiply a[i] by the product of everything to the right of i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            a[i] = a[i] * right;
            right = right * nums[i];
        }

        return a;
    }
}