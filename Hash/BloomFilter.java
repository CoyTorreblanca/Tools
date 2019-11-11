import java.util.*;

public class BloomFilter<T>
{
	private boolean bloom[][];

	// Initialize bloom filter with given array,sizes, length hash tables.
	// Each hash table's size is given in given array sizes.
	// sizes.length must be greater than zero.
	BloomFilter(int [] sizes)
	{
		if (sizes != null && sizes.length > 0)
		{
			bloom = new boolean[sizes.length][];
			for (int i = 0; i < bloom.length; i++)
			{
				bloom[i] = new boolean[sizes[i]];
			}
		}

		else
		{
			bloom = null;
		}
	}

	// Given a value, insert it into bloom filter
	public void insert(T value)
	{
		for(int i = 0; i < bloom.length; i++)
		{
			int hash = value.hashCode();

			// Hash value are susceptible of integer overflow.
			if (hash < 0) hash = hash - Integer.MIN_VALUE;

			hash = hash % bloom[i].length;

			bloom[i][hash] = true;
		}
	}

	// Given a value, return true if it's hash value is in all hash tables in bloom filter.
	public boolean contains(T value)
	{
		for(int i = 0; i < bloom.length; i++)
		{
			
			int hash = value.hashCode();
			
			if (hash < 0) hash = hash - Integer.MIN_VALUE;

			hash = hash % bloom[i].length;

			if( bloom[i][hash] == false)
				return false;
		}

		return true;
	}

	// Calculate false positive rate of searching for a value.
	// Find false positive rate in each hash table by counting the number of indexes that
	// equal true and dividing that by the size of the hash table.
	// False positive rate of bloom filter is false positive rate of all hash tables multiplied together.
	public double falsePositive()
	{
		double result = 1.0;

		for (int i = 0; i < bloom.length; i++)
		{
			int count = 0;

			for (int j = 0; j < bloom[i].length; j++)
				if(bloom[i][j] == true)
					count++;
			
			result *= (double)(count/bloom[i].length);
		}

		return result * 100;
	}

}



