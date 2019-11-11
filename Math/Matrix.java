// Matrix class contains a matrix in the form of a two do array.
// Currently supports the addition of two matrices and a simple toString method.  

import java.util.ArrayList;
public class Matrix
{
	// Matrix is implemented as a 2D array.
	private int [][] matrix;
	// The amount of rows in the Matrix.
	private int rowCapacity;
	// The amount of columns in each row.
	private int [] columnCapacities;

	// Instantiate rowxcolumn Matrix.
	// O(rowCapacity)
	Matrix(int row, int column)
	{
		matrix = new int[row][column];

		rowCapacity = row;
		
		columnCapacities = new int[rowCapacity];
		for (int i = 0; i < rowCapacity; i++)
			columnCapacities[i] = column;	
	}
	
	// Instantiate a Matrix using the given 2D array.
	// O(rowCapacity)
	Matrix(int [][] matrix)
	{
		if (matrix != null)
		{
			this.matrix = matrix;

			rowCapacity = matrix.length;

			columnCapacities = new int[rowCapacity];
			for (int row = 0; row < rowCapacity; row++)
				columnCapacities[row] = matrix[row].length;
		}
		else
		{
			matrix = null;
			rowCapacity = 0;
			columnCapacities = null;
		}
	}

	// Returns the difference between the two column capacities arrays from the two given Matrices.
	// Matrix B columns are subtracted from Matrix A columns.
	// Return null if given a null Matrix.
	// O(A.rowCapactiy + B.rowCapacity)	
	public static int []  diffColumns(Matrix A, Matrix B)
	{
		// Function does not accept null parameters.
		if (A == null || B ==  null) return null;

		// large, small, and largeID differentiate the two Matrices by size.
		Matrix large = A.rowCapacity > B.rowCapacity ? A : B;
		Matrix small = A == large ? B : A;
		char largeId = A == large ? 'A' : 'B';

		// Initialize the array which will hold the differences between Matrix A columns and Matrix B columns.
		// The size of the return array is the size of the larger of the two column capacity arrays.
		int [] columns = new int[large.rowCapacity];

		// Iterate through all the rows the smaller Matrix has.
		// Save the difference in the collumn sizes between the two Matrices in the columns array.
		int row;
		for (row = 0; row < small.rowCapacity; row++)
		{
			columns[row] = A.matrix[row].length - B.matrix[row].length;
		}

		// Find the Matrix with the larger row size,
		// And finish filling the column capacity array with its values.
		if (largeId == 'A')
		{
			for (int i = row; i < large.rowCapacity; i++)
			{
				columns[i] = A.matrix[i].length - 0;
			}
		}
		
		else
		{
			for (int i = row; i < large.rowCapacity; i++)
			{
				columns[i] = 0 - B.matrix[i].length;
			}
		}	

		return columns;
	}

	// Returns how many more columns the first given 2D array has compared to the second given 2D array.
	// O(A.rowCapacity + B.rowCapacity)
	public static int [] diffColumns(int [][] A, int[][] B)
	{
		return diffColumns(new Matrix(A), new Matrix(B));
	}


	// Given two 2D arrays, returns the difference in their number of rows.
	// If given are null, returns -999999.
	// O(1)	
	public static int diffRows(int [][] A, int [][] B)
	{
		return diffRows(new Matrix(A), new Matrix(B));
	}

	// Given two 2D arrays, returns the difference in their number of rows.
	// If given are null, returns -999999.
	//O(1)
	public static int diffRows(Matrix A, Matrix B)
	{
		if (A == null || B == null)
			return -999999;
		return A.matrix.length - B.matrix.length;
	}
	
	// Given two Matrices, return a Matrix which is the sum of the two given Matrices.
	// Element Aij and Bij are added to make Cij.
	// Matrices A and B must have the same columns and rows, otherwise return null.
	// Returns null if either A or B is null.
	// O(A.rowCapacity * A.columnCapacities[])
	public static Matrix matrixAddition(int[][] A, int[][] B)
	{
		return matrixAddition(new Matrix(A), new Matrix(B));
	}

	// Given two Matrices, return a Matrix which is the sum of the two given Matrices.
	// Element Aij and Bij are added to make Cij.
	// Matrices A and B must have the same columns and rows, otherwise return null.
	// Returns null if either A or B is null.
	// O(A.rowCapacity * A.columnCapacities[])
	public static Matrix matrixAddition(Matrix A, Matrix B)
	{
		if (A == null || B == null)
			return null;

		// If the Matrices don't have the same number of rows, return null.
		if (diffRows(A,B) != 0) 
			return null;

		// If the Matrices dont have the same number of columns, return null.
		int [] diffCol = diffColumns(A,B);
		for (int row = 0; row < A.rowCapacity; row++)
		{
			if(diffCol[row] != 0) return null;
		}
	
		Matrix C  = new Matrix(A.rowCapacity, A.columnCapacities[0]);
		
		// Iterate through each element in both Matrices, and add their sum in the corresponding cell in the new Matrix, C.
		for (int row = 0; row < A.rowCapacity; row++)
			for (int column = 0; column < A.columnCapacities[0]; column++)
				C.matrix[row][column] = A.matrix[row][column] + B.matrix[row][column];
		return C;
	}

	// Convert Matrix to a readable string format.
	// Currently only works with single digit numbers.
	public String toString()
	{
		int size = 0; // Size of string
		for (int row = 0; row < rowCapacity; row++)
		{
			size += 1 + 4 * columnCapacities[row];
		}
		char [] str = new char[size];

		int index = 0;

		for (int row = 0; row < rowCapacity; row++)
		{
			str[index++] = '[';

			for (int column = 0; column < columnCapacities[row]; column++)
			{
				int temp = matrix[row][column];

				if (temp < 0)
				{
					str[index++] = '-';
					temp *= -1;
					str[index++] = (char)(temp + '0');
				}
				
				else
					str[index++] = (char)(temp + '0');

				if (column != columnCapacities[row] - 1)
				{
					str[index++] = ',';
					str[index++] = ' ';
				}
			}

			str[index++] = ']';
			str[index++] = '\n';
			
		}
	
		return new String(str);
	}

	// Convert Matrix to an ArrayList<ArrayList<Integer>>.
	// If current Matrix is null, return null.
	// O(rowCapacity * columnCapacity[]) 
	public ArrayList<ArrayList<Integer>> toArrayList()
	{
		if (matrix == null)
			return null;

		// Initialize return ArrayList
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		// For each row, Initialize column ArrayList,
		// And for each column, add the Matrix element to the ArrayList.	
		for (int row = 0; row < rowCapacity; row++)
		{
			ArrayList<Integer> temp = new ArrayList<>();
			
			for (int column = 0; column < columnCapacities[row]; column++)
				temp.add(matrix[row][column]);

			res.add(temp);
		}

		return res;
	}

	public static void main(String [] args)
	{
		// Test Case
		int [][] coordinates = new int [8][2];
		Matrix mCoo = new Matrix(coordinates);
		System.out.println(mCoo.toString());

		int [][] coordinates2 = {
						{2,1},
						{2,-1},
						{-2,1},
						{-2,-1},
						{1,2},
						{1,-2},
						{-1,2},
						{-1,-2}
					};

		Matrix aCoo = new Matrix(coordinates2);
		System.out.println('\n' + aCoo.toString());
		System.out.println("Matrix Row Capacities: " + aCoo.rowCapacity + mCoo.rowCapacity);

		Matrix C = matrixAddition(aCoo, mCoo);
		if (C == null)
			System.out.println("OOOps");
		else
			System.out.println('\n' + C.toString());
	}
}
