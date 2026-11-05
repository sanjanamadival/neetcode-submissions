// class Solution {
//     public int characterReplacement(String s, int k) {
//         int best = 0;

//         for (int i = 0; i < s.length(); i++) {          // i = where the substring starts
//             int[] count = new int[26];                  // fresh counts for each start (A to Z)
//             int maxCount = 0;                           // most frequent letter count so far

//             for (int j = i; j < s.length(); j++) {      // j = extends the substring
//                 int idx = s.charAt(j) - 'A';            // 'A' -> 0, 'B' -> 1, ... (Stage 1 trick)
//                 count[idx]++;

//                 if (count[idx] > maxCount) {
//                     maxCount = count[idx];
//                 }

//                 int length = j - i + 1;
//                 int needed = length - maxCount;         // replacements needed

//                 if (needed <= k) {
//                     if (length > best) {
//                         best = length;
//                     }
//                 } else {
//                     break;                              // too many replacements, stop this start
//                 }
//             }
//         }
//         return best;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];     // one set of counts for the whole string
        int left = 0;
        int maxCount = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {   // right extends the window
            int idx = s.charAt(right) - 'A';
            count[idx]++;

            if (count[idx] > maxCount) {
                maxCount = count[idx];
            }

            int length = right - left + 1;
            int needed = length - maxCount;

            if (needed > k) {                       // too many replacements
                count[s.charAt(left) - 'A']--;      // remove the leftmost letter
                left++;                             // shrink the window from the left
            }

            length = right - left + 1;
            if (length > best) {
                best = length;
            }
        }
        return best;
    }
}