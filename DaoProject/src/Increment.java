
public class Increment {

	public static void main(String[] args) {
		int  x;
		int  y;

		// Increment operators
		x = 1;
		y = ++x;    // x is now 2, y is also 2
		y = x++;    // x is now 3, y is 2
		System.out.println("result " +x);
		System.out.println("result " +y);
		// Decrement operators
		x = 3;
		y = x--;    // x is now 2, y is 3
		y = --x;
		System.out.println("result " +x);
		System.out.println("result " +y);
		
	}

}
