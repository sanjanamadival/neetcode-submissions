class Solution {
    public boolean isPalindrome(String s) {
        String a="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                a=a+Character.toLowerCase(c);
            }        
        }
        char[] b= a.toCharArray();
        for(int i=0,j=b.length-1;i<j;i++,j--){
            if(b[i]!=b[j]){
                return false;
            }
        }
        return true;
    }
}
