class Solution {
    public int lengthOfLongestSubstring(String s) {
                if (s.length() != 0) {

            String output = "";
            HashMap<Character, Integer> resultMap = new HashMap<>();
            for (int start = 0, end = 0; end < s.length(); end++) {
                char currentLetter = s.charAt(end);
                if (resultMap.containsKey(currentLetter)) {
                    start = Math.max(resultMap.get(currentLetter) + 1, start);
                }
                if (output.length()<end-start+1){
                    output = s.substring(start,end+1);
                }
                resultMap.put(currentLetter,end);
            }

            return output.length();
        } else {
            return 0;
        } 
}
}