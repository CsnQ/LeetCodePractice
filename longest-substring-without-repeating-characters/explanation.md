#### Explanation of this code

as well as my own brain I also looked at https://www.baeldung.com/java-longest-substring-without-repeated-characters

If we take the following example of String `String s = "pwwkew"` we know we need to
come back with 3 as the longest number of consectutive non repeating letters.

In our method we initialise an empty string we will call output:
`String output = "";`

We are also going to create a HashMap which will keep track of the letters we have looked at:
`HashMap<Character, Integer> resultMap = new HashMap<>();`

we are going to traverse our string from left to right and keep track of:
* our current substring with non repeating characters using a start and end index
* the longest non repeating substring which we are storing in *output*
* a table of characters we have already visited (resultMap)

we start our for loop instatiating our start and end variables:
`for (int start = 0, end = 0; end < s.length(); end++) {`

next we create a placeholder for our current character. So when this loop runs the first time it will be 'p':
`char currChar = input.charAt(end);` - note it is associated the 'end' variable. 

then we have a few things happening:
` if (resultMap.containsKey(currentLetter)) 
{start = Math.max(resultMap.get(currentLetter) + 1, start);}`
                `if (output.length()<end-start+1){`
                   ` output = s.substring(start,end+1);`
                `}`
                `resultMap.put(currentLetter,end); `

first, we check if that character is in our HashMap:
`if (resultMap.containsKey(currentLetter)) {start = Math.max(resultMap.get(currentLetter) + 1, start);}`
 if it is, we update our 'start' variable. Here we are using Math.Max which takes an argument of 2 integers and tells us which one is bigger.When this loop runs the first time, nothing will happen, so we head to the next check:
 `if (output.length()<end-start+1){output = s.substring(start,end+1);}`
 this is where we are starting to build our substring using these start and end variables. 
 
 we will then also add the current letter to our map:
`resultMap.put(currentLetter,end); `

so what will happen when this loop runs first and second time?
# First time loop runs
* start and end are both 0
* currentLetter = 'p'
* resultMap does not contain this letter
* output.length is less than end-start+1 (0-1) so output = "p" because start=0 end+1 = 1
* our letter is added to our HashMap

# Second time loop runs
* start = 0 but end =1
* currentLetter will now become 'w'
* w is not in our hashmap
* output.length is less than end-start+1 (0-1) so output = "p" because start=0 end+1 = 2
* our output now = "pw" as a result
* our letter is added to the hashmap

#Third time Loop runs
* start = 0 , end = 2
* currentLetter is 'w'
* w is in our hashmap so we check which is bigger, the number we stored agaisnt w in our table+1 or our start value. as start is currently 0 is it is the former number that is bigger and now start becomes 2.
* output.length is still less than end-start+1(3) so output becomes 'pw' still 

# Fourth time Loop runs
* start = 2 , end = 3
* currentLetter is 'k'
* k is not in our hashmap 
* output.length is still less than end-start+1(4) so output becomes 'pw' still 

# Fifth time Loop runs
* start = 2 , end = 4
* current letter 'e'
* e is not in our hashmap 
* etc etc

summary: the algo motors through our characters until it encounters one it has seen before and when that happens it will mark that and store the substring. 