package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TreeAVL<T> implements Iterable<T>{
	private Node<T> root;
	private Comparator<T> comparator;

	public TreeAVL(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(root);
	}
	
	public Node<T> getRoot(){
		return root;
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	public int getFe() {
		return getFe(root);
	}

	private int getFe(Node<T> node) {
		if (node == null)
			return -1;
		return node.getFe();
	}
	
	public T search(T data){
		return search(data, root);
	}

	public T search(T data, Node<T> node) {
		if (node == null) {
			return null;
		}
		if (node.getData() == data) {
			return node.getData();
		} else if (comparator.compare(data, node.getData()) < 0) {
			return search(data, node.getLeft());
		} else {
			return search(data, node.getRight());
		}
	}
	
	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> node, T data) {
		if (node == null)
			return new Node<T>(data);
		if (comparator.compare(data, node.getData())<0) {
			node.setLeft(insert(node.getLeft(), data));
		} else if (comparator.compare(data, node.getData())>0) {
			node.setRight(insert(node.getRight(), data));
		} else {
			node.setData(data);
			return node;
		}
		node.setFe(1 + Math.max(getFe(node.getLeft()), getFe(node.getRight())));
		return balance(node);
	}

	private Node<T> balance(Node<T> node) {
		if (balanceFactor(node) > 1) {
			if (balanceFactor(node.getRight()) < 0) {
				node.setRight(rotateRight(node.getRight()));
			}
			node = rotateLeft(node);
		} else if (balanceFactor(node) < -1) {
			if (balanceFactor(node.getLeft()) > 0) {
				node.setLeft(rotateLeft(node.getLeft()));
			}
			node = rotateRight(node);
		}
		return node;
	}

	private int balanceFactor(Node<T> node) {
		return getFe(node.getRight()) - getFe(node.getLeft());
	}

	private Node<T> rotateRight(Node<T> node) {
		Node<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.setFe(1 + Math.max(getFe(node.getLeft()), getFe(node.getRight())));
		aux.setFe(1 + Math.max(getFe(aux.getLeft()), getFe(aux.getRight())));
		return aux;
	}

	private Node<T> rotateLeft(Node<T> node) {
		Node<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.setFe(1 + Math.max(getFe(node.getLeft()), getFe(node.getRight())));
		aux.setFe(1 + Math.max(getFe(aux.getLeft()), getFe(aux.getRight())));
		return aux;
	}

	public void remove(T data) {
		root = remove(root, data);
	}

	private Node<T> remove(Node<T> node, T data) {
		if (comparator.compare(data, node.getData())<0) {
			node.setLeft(remove(node.getLeft(), data));
		} else if (comparator.compare(data, node.getData())>0) {
			node.setRight(remove(node.getRight(), data));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				Node<T> aux = node;
				node = getMin(aux.getRight());
				node.setRight(removeMin(aux.getRight()));
				node.setLeft(aux.getLeft());
			}
		}
		node.setFe(1 + Math.max(getFe(node.getLeft()), getFe(node.getRight())));
		return balance(node);
	}

	private Node<T> removeMin(Node<T> node) {
		if (node.getLeft() == null)
			return node.getRight();
		node.setLeft(removeMin(node.getLeft()));
		node.setFe(1 + Math.max(getFe(node.getLeft()), getFe(node.getRight())));
		return balance(node);
	}

	private Node<T> getMin(Node<T> node) {
		if (node.getLeft() == null)
			return node;
		return getMin(node.getLeft());
	}

	  public List<T> getPreOrder(){
			List<T> list = new ArrayList<T>();
			preOrder(root, list);
			return list;
		}
		

		public void preOrder(Node<T> node, List<T> list) {
			if(node!=null) {
				list.add(node.getData());
				preOrder(node.getLeft(), list);
				preOrder(node.getRight(), list);
			}
		}

		public int count() {
			List<T> list = getPreOrder();
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				count ++;
			}
			return count;
		}
		
		public List<T> getInOrder(){
			List<T> list = new ArrayList<T>();
			inOrder(root, list);
			return list;
		}
		

		public void inOrder(Node<T> node, List<T> list) {
			if(node!=null) {
				inOrder(node.getLeft(), list);
				list.add(node.getData());;
				inOrder(node.getRight(), list);
			}
		}
		
		public List<T> getPostOrder(){
			List<T> list = new ArrayList<T>();
			postOrder(root, list);
			return list;
		}
		

		public void postOrder(Node<T> name, List<T> list) {
			if(name!=null) {
				postOrder(name.getLeft(), list);
				postOrder(name.getRight(), list);
				list.add(name.getData());;
			}
		}
}
