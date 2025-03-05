import java.util.Iterator;

/**
 * A stack implementation using a linked list.
 * @author Daniel Pantyukhov & Valentim Khakhitva
 * @version 1.0 [public]
 */
public class StackList<T>
{

	/**
	 * A node class that contains the content of the node and a reference to the next node.
	 * @param <T> The type of the content of the node.
	 * @param content The content of the node.
	 * @param next The reference to the next node.
	 */
	private class Node {

		private T content;
		private Node next;

		public Node(T content) {

			this.content = content;
			this.next = null;

		}

	}

	private Node top;
	private int size;

	/**
	 * Constructor for the StackList class.
	 */
	public StackList()
	{
		top = null;
		size = 0;
	}

	/**
	 * @return The size of the stack.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * A shallow copy in this case is point to the same objects as in the original stack, but the new stack itself is a different object.
	 * @return A shallow copy of the stack.
	 */
	public StackList<T> shallowCopy()
	{
		StackList<T> copy = new StackList<>();
		if (!this.isEmpty()) {
			Node currentNode = this.top;
			Node copyNode = new Node(currentNode.content);

			copy.top = copyNode;
			currentNode = currentNode.next;
			
			while (currentNode != null) {
				copyNode.next = new Node(currentNode.content);
				copyNode = copyNode.next;
				currentNode = currentNode.next;
			}
			
			copy.size = this.size;
		}
		return copy;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Adds an item to the top of the stack.
	 * @param item The item to be added to the stack (Content).
	 */
	public void push(T item)
	{
		Node node = new Node(item);
		node.next = top;
		top = node;
		size++;
	}

	/**
	 * Removes the item from the top of the stack.
	 * @return The item that was removed from the top of the stack.
	 */
	public T pop()
	{
		if (isEmpty()) return null;

		T item = top.content;
		top = top.next;
		size--;
		return item;
	}

	/**
	 * Returns the item from the top of the stack without removing it.
	 * @return The item from the top of the stack.
	 */
	public T peek() {
		if (isEmpty()) return null;
		return top.content;
	}

	public Iterator<T> iterator()
	{
		return new StackListIterator();
	}

	/**
	 * An iterator class that iterates through the stack from the top to the bottom.
	 * @param <T> The type of the content of the stack.
	 */
	private class StackListIterator implements Iterator<T> {

		private Node current = top;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {

			if (!hasNext()) {
				throw new IllegalStateException("There is no next element");
			}

			T item = current.content;
			current = current.next;
			return item;

		}

	}

	public static void main(String[] args)
	{
	}
}