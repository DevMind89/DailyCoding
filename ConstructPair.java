/*
 
Good morning! Here's your coding interview problem for today.

This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
    
Implement car and cdr. 

*/

public class ConstructPair {

	public static void main(String[] args) {
		Pair pair = cons(3, 4);
		System.out.println(pair.car());
		System.out.println(pair.cdr());
	}
	
	public interface Pair{
		int car();
		int cdr();
	}
	
	public static Pair cons(int a, int b) {
		return new Pair() {
			public int car() {
				return a;
			}

			public int cdr() {
				return b;
			}
		};			
	}
}
