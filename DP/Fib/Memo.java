// Coy Torreblanca, 12/3/2019
// Memoization Solution to Fibonnaci
// Space Complexity: O(n^2)
// Time Complexity: O(n)

public class Memo
{
	private static int fibDr(int n, int [] memo)
	{

		// Check cache
		if (memo[i])
			return memo[i];
		// Add to cache
		// Save State
		memo[i] = fibDr(n - 1) - fibDr(n - 2);

		return memo[i];
	}

	
	public static int fib(int n)
	{
		if (n < 0)
			return - 1;

		// Initialize Memo
		int [] memo = new int [n]
		memo[0] = 0;
		memo[1] = 1;

		// Call Driver
		return fib(n, memo);
	}

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


