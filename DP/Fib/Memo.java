// Coy Torreblanca, 12/3/2019
// Memoization Solution to Fibonnaci
// Space Complexity: O(n^2)
// Time Complexity: O(n)

import java.util.HashMap;

public class Memo
{
	private static int fibDr(int n, HashMap<Integer, Integer> memo)
	{

		// Check cache
		Integer mem = memo.get(n);
		if (mem != null)
			return mem;
		// Process nth fib
		mem = fibDr(n - 1, memo) - fibDr(n - 2, memo); 
	        // Save state	
		memo.put(n, mem);
		return mem;
	}

	
	public static int fib(int n)
	{
		if (n < 0)
			return - 1;

		// Initialize Memo
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>(n);
		memo.put(0, 0);
		memo.put(1, 1);

		// Call Driver
		return fibDr(n, memo);
	}

	public static void main(String [] args)
	{
		// Process Fib numbers up to the nth number
		HashMap<Integer, Integer> fibs = FibSet.Fib();

		// Calculate every Fib and cross reference with Map
		for (int i = 0; i < fibs.size(); i++)
		{
			if (fibs.get(i) != fib(i))
			       System.err.println("ERR");
		}

		System.err.println("PASS");
	}
}


