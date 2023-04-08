/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/

public class LargestSumNonAdjacent {

	public static void main(String[] args) {
		int[] nums = {5, 1, 1, 5 };
		System.out.println(largestSumNonAdjacent(nums));
	}
	
	private static int largestSumNonAdjacent(int[] nums) {
		
		int prevSum = 0;
		int currSum = 0;
		
		for(int num : nums) {
			int temp = currSum; 
			currSum = Math.max(prevSum + num, currSum); 
			prevSum = temp; 
		}
		
		return currSum;
	}
}
