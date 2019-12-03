// Coy Torreblanca, 12/3/2019
// Naive Recursion Solution to Fibonacci
// Space Complexity: O(n)
// Time Complexity: O(2^n) || O(phi^n)
// F(0) = 0
// F(1) = 1
// F(n) = F(n - 1) + F(n - 2)

public class Naive
{
	private static int fibDr(int n)
	{
		// Base case
		if (n < 2)
			return  n;
		// Recursive Descent
		return fibDr(n - 1) - fibDr(n - 2);
	}

	public static int fib(int n)
	{
		if (n < 0)
			return -1;
		return fib(n);
	}

	// Test
	public static void main(String [] args)
	{
		int [] fibs = new int [N];

		cache = Fib();

		for (int i = 0; i < N; i++)
		{
			if (fibs[i] != fibDr(n))
			       System.err.println("ERR");
		}

		System.err.println("PASS");
	}	
}