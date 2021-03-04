# Explanation of this code

goal: reverse an array in place without copying to a new array. so:
["h","e","l","l","o"]
should become 
["o","l","l","e","h"]

input to this method is: char[] s.

* first we store the arrayLength which here is 5. 

* we will also be needing n/2 which in this case is 2 (remember using '/' will round down to the nearest whole number)

* then we create a for loop:
` for (int i = 0; i < arrayLength/2 ; i++) `

### First time loop runs
* tempChar = 'h'
* i is 0
* arrayLength-1-i = '0' because we are index 0, our length is i which -1 is 4, thus selecting the last letter in the array
* s[i] will therefore become 0
*  A[n - 1 - i] = tempChar therefore means that the last letter in our array becomes 'h' starting the swap. 


### Second time loop runs
* we shift along, so that temp becomes s[1] and n-1-i is position 3 and do the same. 
* that's why the loop runs for only half the length of our array as we are basically starting at either end and stop when we meet the middle. the middle letter doesn't have to move. 

int arrayLength = s.length;
        
        for (int i = 0; i < arrayLength/2 ; i++) {

            char tempChar = s[i];
            s[i] = s[arrayLength-1-i];
            s[arrayLength-1-i]=tempChar;
        }
    }