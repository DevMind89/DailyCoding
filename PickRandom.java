import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
*/

public class PickRandom {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		InputStream stream = new ByteArrayInputStream(
				Arrays.stream(arr).mapToObj(Integer::toString).reduce("", (a, b) -> a + " " + b).getBytes());
		System.out.println(randomElement(stream));
	}

	private static int randomElement(InputStream stream) {

		int result = 0;
		Random rand = new Random();
		int count = 0;
		Scanner sc = new Scanner(stream);

		while (sc.hasNext()) {

			int current = sc.nextInt();
			count++;

			if (rand.nextInt(count) == 0) {
				result = current;
			}
		}

		sc.close();
		return result;
	}
}
