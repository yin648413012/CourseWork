/**
 * An interface including the ForwardIterator and ReverseIterator methods
 * 
 * author: Brian Loi
 */

public interface Iterables<E> {
	// This interface is complete
	public ForwardIterator<E> forwardIterator();

	public ReverseIterator<E> reverseIterator();
}
