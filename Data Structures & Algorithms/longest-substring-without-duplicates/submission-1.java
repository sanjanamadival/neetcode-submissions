// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int best = 0;

//         for (int i = 0; i < s.length(); i++) {          // i = where the substring starts
//             String a = "";                              // fresh string for each start

//             for (int j = i; j < s.length(); j++) {      // j = walks forward from i
//                 char c = s.charAt(j);

//                 if (a.indexOf(c) != -1) {               // c is already in a -> repeat
//                     break;                              // stop this start, go to next i
//                 }

//                 a = a + c;                              // no repeat, add the letter

//                 if (a.length() > best) {
//                     best = a.length();
//                 }
//             }
//         }
//         return best;
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        String a = "";
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int pos = a.indexOf(c);          // -1 if c is not in a
            if (pos != -1) {
                a = a.substring(pos + 1);    // drop everything up to the old copy of c
            }

            a = a + c;                       // add the new letter

            if (a.length() > best) {
                best = a.length();
            }
        }
        return best;
    }
}