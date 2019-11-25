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
			back = null;
			front.setNext(back);
			return front;
		}

		// If LinkedList only has one node
		if (back == null)
		{
			back = new Node<T>(data, front, null);
			front.setNext(back);
			return back;
		}

		Node<T> nuevo = new Node<T>(data, back, null);
		back.setNext(nuevo);
		back = nuevo;
		return back;
	}

	public Node<T> remove()
	{
		if (front == null)
		       return null;
		
		if (back == null)
		{
			Node<T> temp = front;
			front = null;
			return front;
		}
	
		Node<T> temp = back;
		back = back.prev();

		if (back == null)
			front = null;

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
}
