import java.util.*;

public class LinkedList<T>
{
	private Node<T> front;
	private Node<T> back;

	LinkedList()
	{
		front = null;
		back = null;
	}

	LinkedList(Node<T> head)
	{
		front = head;
		back = head;
	}

	public Node<T> insert(T data)
	{
		// If LinkedList is empty
		if (front == null)
		{
			front = new Node<T>(data);
			back = front;
			return front;
		}

		Node<T> nuevo = new Node<T>(data, back, null);
		back.setNext(nuevo);
		back = nuevo;
		return nuevo;
	}

	public Node<T> remove()
	{
		if (front == null)
		       return null;
		
		Node<T> temp = back;
		back = back.prev();

		if (back == null)
			front = null;
		else
			back.setNext(null);

		return temp;
	}

	public String toString()
	{
		Node<T> temp = front;
		StringBuilder r = new StringBuilder();
		while (temp != null)
		{
			r.append(temp.getData().toString());
			temp = temp.next();
		}
		return r.toString();
	}

	class Node<T>
	{
		private T data;
		private Node <T> prev, next;

		Node(T data)
		{
			this.data = data;
			prev = null;
			next = null;
		}

		Node(T data, Node<T> prev, Node<T> next)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public Node<T> next()
		{
			return next;
		}

		public Node<T> prev()
		{
			return prev;
		}

		public void setNext(Node<T> next)
		{
			this.next = next;
		}

		public void setPrev(Node<T> prev)
		{
			this.prev = prev;
		}

		public T getData()
		{
			return data;
		}
	}

	public static void main (String [] args)
	{
		Scanner scan = new Scanner(System.in);
		String menu = "1. Insert, 2. Remove, 3. Print";
		LinkedList<String> ll = new LinkedList<String>();

		int x = 1;

		while(x == 1 || x == 2 || x == 3)
		{
			System.out.println(menu);
			x = scan.nextInt();

			if (x == 1)
				ll.insert(scan.next());
			else if (x == 2)
				ll.remove();
			else if (x == 3)
				System.out.println(ll.toString());
		}
	}	
}
