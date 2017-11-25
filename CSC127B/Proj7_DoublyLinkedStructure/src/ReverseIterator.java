/**
 * An interface including a hasPrev and next methods for the ReverseInterator
 * class
 * 
 * author: Brian Loi
 */

public interface ReverseIterator<E> {
	// This interface is complete
	public boolean hasPrev();

	public E prev();
}
