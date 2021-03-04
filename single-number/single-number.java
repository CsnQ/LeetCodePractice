class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            if(numMap.containsKey(nums[i])){
                numMap.put(nums[i], numMap.get(nums[i])+1);
            }else{
                numMap.put(nums[i], 1);
            }
        }
        
        int expectedValue = 1;
        int result=0;
        
        for (int key : numMap.keySet()){
            if (numMap.get(key)==expectedValue){
               result = key; 
            }
        }
        
        return result;
    }
}