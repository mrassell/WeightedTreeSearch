public class BinaryHeap {
    private TreeNode[] heap;
    private int size;

    public BinaryHeap(int capacity) {
        heap = new TreeNode[capacity + 1];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(TreeNode node) {
        if (size >= heap.length - 1) resize();
        size++;
        heap[size] = node;
        bubbleUp(size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode removeMin() {
        if (size == 0) {
            System.out.println("Heap is empty.");
        }
        TreeNode min = heap[1];
        heap[1] = heap[size];
        size--;
        bubbleDown(1);
        return min;
    }

    private void bubbleUp(int pos) {
        while (pos > 1 && heap[pos].compareTo(heap[pos / 2]) < 0) {
            swap(pos, pos / 2);
            pos /= 2;
        }
    }

    private void bubbleDown(int pos) {
        while (2 * pos <= size) {
            int child = 2 * pos;
            if (child < size && heap[child + 1].compareTo(heap[child]) < 0) child++;
            if (heap[pos].compareTo(heap[child]) <= 0) break;
            swap(pos, child);
            pos = child;
        }
    }

    private void swap(int a, int b) {
        TreeNode temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void resize() {
        TreeNode[] newHeap = new TreeNode[heap.length * 2];
        System.arraycopy(heap, 1, newHeap, 1, size);
        heap = newHeap;
    }
}