package structures;

public class Node<T> {
	
	    private T data;     
		private int fe;      
	    private Node<T> left, right;     

	    public Node(T data) {
	        this.data = data;
	        this.fe = 0;
	    }

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public int getFe() {
			return fe;
		}

		public void setFe(int fe) {
			this.fe = fe;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
	    
	    
}
