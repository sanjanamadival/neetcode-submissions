class Solution {

    public String encode(List<String> strs) {
        ArrayList<Integer> code =new ArrayList<>();
        for(int i=0;i<strs.size();i++){
            for(int j=0;j<strs.get(i).length();j++){
                code.add((int)(strs.get(i).charAt(j)));
            }
            code.add(-1);
        }
        String s="";
        for(int i=0;i<code.size();i++){
            s=s+code.get(i)+",";
        }
        return s;
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
           if (str.length() == 0) {
            return result;
        }
        String [] parts = str.split(",");
        String word="";

    for (int i = 0; i < parts.length; i++) {
        int n = Integer.parseInt(parts[i]);  
        if (n != -1) {
            word = word + (char) n;           
        } else {
            result.add(word);              
            word = "";                      
        }
    }
        return result;
    }
}
