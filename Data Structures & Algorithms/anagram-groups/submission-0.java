class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> a = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] b = strs[i].toCharArray();
            Arrays.sort(b);
            String key = new String(b);
            // System.out.println(key);
            if(!a.containsKey(key)){
                a.put(key,new ArrayList<>());
            }
            a.get(key).add(strs[i]);
        }
        return new ArrayList<>(a.values());
    }
}
