class Solution {
    public void reverseString(char[] s) {
        int arrayLength = s.length;
        
        for (int i = 0; i < arrayLength/2 ; i++) {

            char tempChar = s[i];
            s[i] = s[arrayLength-1-i];
            s[arrayLength-1-i]=tempChar;
        }
    }
}