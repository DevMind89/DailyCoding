/*
Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
*/


import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {

		int k = 12;
		int[] nums = { 15, 10, 5, 7 };
		System.out.println(hasTwoSum(nums, k));
	}

	public static boolean hasTwoSum(int nums[], int k) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int num : nums) {
			if (set.contains(k - num)) { // 12-15=-3 | 12-10=2 | 12-5=7 | 12-7=5
				return true;
			}
			set.add(num); // 15,10,5
		}
		return false;
	}
}
