class Solution {
    public int distributeCandies(int[] candyType) {
         int totalCandies = candyType.length;
        int candiesToBeEaten = totalCandies/2;
        List<Integer> distinctCandies =getDistinctTypesOfCandy(candyType);
        int numDistinctCandies = distinctCandies.size();

        int result = getCombinations(numDistinctCandies,candiesToBeEaten);
        return result;
    }
    
       public List<Integer> getDistinctTypesOfCandy(int[] candyType){
        Integer[] candies = Arrays.stream( candyType ).boxed().toArray( Integer[]::new );
        List<Integer> distinctCandies = Arrays.stream(candies).distinct().collect(Collectors.toList());
        return distinctCandies;

    }
    
    public int getCombinations(int numDistinctCandies, int candiesToBeEaten){
        if (numDistinctCandies==1){
            return 1;
        }else if (numDistinctCandies == candiesToBeEaten||numDistinctCandies<candiesToBeEaten){
         return numDistinctCandies;
        }else if(numDistinctCandies>candiesToBeEaten){
            return candiesToBeEaten;
        }else  {
            return 0;
        }
    }
}