import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public double findClosest() {
        if (root == null) {
            throw new NoSuchElementException("Tree is empty.");
        }

        BinaryHeap heap = new BinaryHeap(100); 
        heap.insert(root);
        root.distance = 0; 

        double shortestDistance = Double.MAX_VALUE; 

        while (!heap.isEmpty()) {
            TreeNode<E> current = heap.removeMin();
            if (current.element.equals("*")) {
                shortestDistance = Math.min(shortestDistance, current.distance);
            }

            if (current.leftChild != null) {
                current.leftChild.distance = current.distance + current.leftChild.distance;
                heap.insert(current.leftChild);
            }

            if (current.rightChild != null) {
                current.rightChild.distance = current.distance + current.rightChild.distance;
                heap.insert(current.rightChild);
            }
        }

        // * was not found if shortestDistance is still Double.MAX_VALUE
        if (shortestDistance == Double.MAX_VALUE) {
            throw new NoSuchElementException("Element '*' not found!");
        }

        return shortestDistance;
    }

    public static BinaryTree<String> parseTree(String input) {
        ArrayStack<TreeNode<String>> stack = new ArrayStack<>(100); 
        StringTokenizer tokenizer = new StringTokenizer(input, " ");

        while (tokenizer.hasMoreTokens()) {
            String temp = tokenizer.nextToken();

            if (temp.equals("(")) {
            } // just a delimiter
            
            else if (temp.equals(")")) {
                TreeNode<String> rightChild = stack.pop();
                TreeNode<String> leftChild = stack.pop();
                TreeNode<String> parent = stack.pop();

                parent.leftChild = leftChild;
                parent.rightChild = rightChild; 

                stack.push(parent);
            } else { // must be an element with a distance
                String element = temp;
                double distance = Double.parseDouble(tokenizer.nextToken()); // first token is the element, the token following it is its distance

                TreeNode<String> node = new TreeNode<>(element); 
                node.distance = distance; 
                stack.push(node);
            }
        }

        // invalid tree construction if there are incomplete pairs of parenthesis for the stack
        if (stack.isEmpty()) {
            System.out.println("Could not construct tree.");
        }

        return new BinaryTree<>(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println("Enter your space-separated binary tree input:");
        System.out.print("> "); 
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BinaryTree<String> tree = parseTree(input);
        try {
            double distance = tree.findClosest();
            System.out.println("Found '*' at distance: " + distance);
        } 
        catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}