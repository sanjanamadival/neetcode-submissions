class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int b = numbers.length;
//         int[] a = new int[2];
//         for (int i = 0; i < b; i++) {
//             for (int j = i + 1; j < b; j++) {
//                 if (numbers[i] + numbers[j] == target) {
//                     a[0] = i + 1;
//                     a[1] = j + 1;
//                     return a;      // stop as soon as found
//                 }
//             }
//         }
//         return a;
//     }
// }