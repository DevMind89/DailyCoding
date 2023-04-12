import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/
public class LongestSusbstringDistinctChar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Give me a string: ");
		String s = sc.next();
		System.out.print("Give me a int: ");
		int k = sc.nextInt();
		
		int length = longestSubstringWithKDistinctChars(s, k);		
		
		System.out.print("The longest substring contains: " + length);
		
		sc.close();		
	}
	
	
	private static int longestSubstringWithKDistinctChars(String s, int k) {
		
		int maxLength = 0;
		Set<Character> chars = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {			
			
			for (int j = i; j < s.length(); j++) {
				
				chars.add(s.charAt(j));
				
				if(chars.size() > k) {
					break;
				}
				
				maxLength = Math.max(maxLength, j - i + 1);
			}
		}
		
		for (Character letter : chars) {
			System.out.println(letter);
		}
		
		return maxLength;
	}
}

