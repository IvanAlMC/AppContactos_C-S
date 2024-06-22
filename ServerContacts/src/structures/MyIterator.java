package structures;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T>{
	private Node<T> actual;

	public MyIterator(Node<T> node) {
		actual = node;
	}

	@Override
	public boolean hasNext() {
		return actual != null;
	}

	@Override
	public T next() {
		T element = actual.getData();
		actual = actual.getRight();
		actual = actual.getLeft();
		return element;
	}
}
