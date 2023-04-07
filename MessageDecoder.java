/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

import java.util.HashMap;
import java.util.Map;

public class MessageDecoder {

	public static void main(String[] args) {
		MessageDecoder decoder = new MessageDecoder();
		System.out.println(decoder.countWaysToDecode("111"));
	}

	public int countWaysToDecode(String message) {

		Map<String, Integer> memo = new HashMap<String, Integer>();
		return countWaysToDecodeHelper(message, memo);
	}

	private int countWaysToDecodeHelper(String message, Map<String, Integer> memo) {

		if (message.length() == 0 || message.length() == 1) {
			return 1;
		}

		if (memo.containsKey(message)) {
			return memo.get(message);
		}

		int count = 0;

		if (message.charAt(0) >= '1' && message.charAt(0) <= '9') {
			count += countWaysToDecodeHelper(message.substring(1), memo);
		}

		if (message.length() >= 2 && message.charAt(0) == '1'
				|| message.charAt(0) == 2 && message.charAt(1) >= '0' && message.charAt(1) <= '6') {
			count += countWaysToDecodeHelper(message.substring(2), memo);
		}

		memo.put(message, count);

		return count;
	}
}
