// Represent Graph as an Adjacency List and/or Adjacency Matrix
// Manipulate a graph's edges and nodes
// Traverse through graph

import java.util.*;
import java.io.*;

// A support class use to represent edges incident to nodes in adjacency lists
class Edge
{
	public static final int minWeight = Integer.MIN_VALUE;

	private int u; // Node number that is origin of edge
	private int v; // Node that is destination of edge
	private int weight; // Weight of edge (minWeight in unweighted graphs)

	Edge(int u, int v, int weight) // Instantiate edge with weight
	{
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	Edge(int u, int v) // Instantiate edge without weight
	{
		this(u, v, minWeight);
	}

	public int getU()
	{
		return u;
	}

	public int getV()
	{
		return v;
	}

	public int getWeight()
	{
		return weight;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) 
			return true;

		if (obj == null)
		       return false;

		if (obj instanceof Edge)
		{
			Edge e = (Edge)obj;
			if (e.u != this.u || e.v != this.v || e.weight != this.weight)
				return false;
			return true;
		}

		return false;
	}

	@Override
	public int hashCode()
	{
		int prime = 31;
		int result = 1;
		result = prime * result + ((Integer)u).hashCode();
		result = prime * result + ((Integer)v).hashCode(); 
		result = prime * result + ((Integer)weight).hashCode();
		return prime;
	}
}


public class LinkedGraph
{ 

	public HashMap<Integer, ArrayList<Edge>> Graph;
	private int n;

	LinkedGraph(File in)
	{
		//File in = new File(fileName);
		//Scanner scan = new Scanner(file);
		
		try
		{
			Scanner scan = new Scanner(in);
				n = scan.nextInt();

			// for each vertex
			for (int i = 1; i <= n; i++)
			{
				// for each neight to vertex i
				int r = scan.nextInt();
				ArrayList<Edge> row = new ArrayList<>(r);

				for (int j = 0; j < r; j++)
					row.add(new Edge(i,j));

				Graph.put(i,row);
			}
		}

		catch(FileNotFoundException e)
		{
			System.err.print(e);
		}
	}
	
	// I'm having problems returning a clone of this graph
	/*	
	public HashMap<Integer, ArrayList<Edge>> Graph()
	{
		if (Graph instanceof HashMap)
		{
			HashMap<Integer, ArrayList<Edge>> out = (HashMap)Graph.clone();
			return out;
		}
		return null;
	}
	*/

	public int size()
	{
		return n;
	}
}
