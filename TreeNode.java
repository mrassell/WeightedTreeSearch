public class TreeNode<E> implements Comparable<TreeNode<E>> {
	public E element;
	public TreeNode<E> leftChild;
	public TreeNode<E> rightChild;
	double distance;
	
	public TreeNode (E element) {
		this.element = element;
	}
	
	public String toString() {
		return element.toString();
	}

	public int compareTo(TreeNode<E> other) {
		if (distance < other.distance) {
			return -1;
		} else if (distance > other.distance) {
			return 1;
		} else {
			return 0;
		}
	}
}
