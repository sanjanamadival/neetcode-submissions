class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] a = new int[k];
        int j = 0;

        int max = 1;                       // size of the biggest group
        int b = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                b++;
            } else {
                b = 1;
            }
            if (b > max) max = b;
        }

        for (int f = max; f >= 1 && j < k; f--) {
            b = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    b = b + 1;
                } else {
                    if (b == f && j < k) {
                        a[j] = nums[i];
                        j++;
                    }
                    b = 1;
                }
            }
        }
        return a;
    }
}
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Arrays.sort(nums);
//         int c = nums.length;
//         if(c==k)return nums;
//         int j = 0;
//         int[] a = new int[c];
//         int b = 1;
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) {
//                 b = b + 1;
//             } else {
//                 b = 1;
//             }
//             if (b >= k) {
//                 boolean x= false;
//                 for(int t=0;t<j;t++){
//                     if(a[t] == nums[i]){
//                         x=true;
//                     }
//                 }
//                 if(!x){
//                 a[j] = nums[i];
//                 j++;
//                 }
//             }
//         }
// int d[]=new int[j];
//     for (int i=0;i<j;i++){
//         if(a[i]!=0){
//            d[i]=a[i];
//         }
//     }
//         return d;
//     }
// }
