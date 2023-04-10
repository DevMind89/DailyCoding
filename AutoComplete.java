/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AutoComplete {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Write dos letters: ");
		String letters = sc.next();
		
		HashSet<String> set = new HashSet<String>();
		set.add("dog");
		set.add("deer");
		set.add("deal");
		
		HashSet<String> set2 = new HashSet<String>();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String word = it.next();
			if(word.startsWith(letters)) {
				set2.add(word);
			}
		}
		
		System.out.println(set2.toString());
	}
}
