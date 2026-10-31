// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         int a=nums.length;
//         List<List<Integer>> result = new ArrayList<>();
//         for(int i=0;i<a;i++){
//             for(int j=i+1;j<a;j++){
//                 for(int k=j+1;k<a;k++){
//                     if(nums[i]+nums[j]+nums[k]==0){
//                         List<Integer> triplet = new ArrayList<>();
//                         triplet.add(nums[i]);
//                         triplet.add(nums[j]);
//                         triplet.add(nums[k]);
//                         if (!result.contains(triplet)) {
//                             result.add(triplet);
//                         }
//                     }
//                 }
//             }
//         }
//         return result;
//     }
// }
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int a = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // skip duplicate i

            int j = i + 1;       // j starts just after i (same as before)
            int k = a - 1;       // k starts at the END instead of j + 1

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);       // no contains() needed now

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;   // skip duplicate j
                } else if (sum < 0) {
                    j++;     // sum too small, need a bigger number
                } else {
                    k--;     // sum too big, need a smaller number
                }
            }
        }
        return result;
    }
}
