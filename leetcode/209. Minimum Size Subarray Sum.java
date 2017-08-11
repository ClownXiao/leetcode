public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int min = Integer.MAX_VALUE;
    	int sum = 0;
    	int left = -1;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        	while(sum >= s){
        		min = Math.min(min, i - left);
        		left++;
        		sum -= nums[left];
        	}
        }
        return min == Integer.MAX_VALUE?0 : min;
    }
}