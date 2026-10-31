// class Solution {
//     public int maxArea(int[] heights) {
//        int best=0;
//        for(int i=0;i<heights.length;i++){
//         for(int j=i+1;j<heights.length;j++){
//             int area=(j-i)*Math.min(heights[j],heights[i]);
//                 if(area>best){
//                     best=area;
//                 }
//             }
//         }
//        return best; 
//     }
// }
class Solution {
    public int maxArea(int[] heights) {
        int best = 0;
        int i = 0;                        // left pointer
        int j = heights.length - 1;       // right pointer

        while (i < j) {
            int area = (j - i) * Math.min(heights[j], heights[i]);
            if (area > best) {
                best = area;
            }

            if (heights[i] < heights[j]) {
                i++;                      // left bar is shorter, drop it
            } else {
                j--;                      // right bar is shorter or equal, drop it
            }
        }
        return best;
    }
}
