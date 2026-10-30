class Solution {
    public int longestConsecutive(int[] nums) {
      Arrays.sort(nums); 
      if(nums.length==0) return 0;
      int best=1;
      int current=1;
      for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]){
            continue;
        }
        else if(nums[i]==nums[i-1]+1){
            current=current+1;
        }
        else{
            current=1;
        }
        if(best<current){
                best=current;
        }
      }
      return best;
    }
}
