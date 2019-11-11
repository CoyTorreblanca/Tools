// Represent Graph as an Adjacency List and/or Adjacency Matrix
// Manipulate a graph's edges and nodes
// Traverse through graph

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


public class Graph
{ 



	
}
