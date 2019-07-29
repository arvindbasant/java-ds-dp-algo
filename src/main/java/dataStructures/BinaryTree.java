package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public class Node {

        Node leftChild;
        Node rightChild;

        int key;

        public Node(int key) {
            this.key = key;
        }

        public void show() {
            System.out.print(key + " ");
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null)
            root = node;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        if (root == null)
            return null;
        else {
            Node current = root;
            while (current.key != key) {
                if (key < current.key) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                if (current == null)
                    return null; // not found
            }
            return current;
        }
    }


    public int size(Node root) {
        if (root == null)
            return 0;
        else {
            return size(root.leftChild) + 1 + size(root.rightChild);
        }
    }

    public Node findMin(Node root) {
        if (root == null)
            return null;
        Node current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    public Node LCA(Node root, int n1, int n2) {
        if (n1 < root.key && n2 < root.key) {
            return LCA(root.leftChild, n1, n2);
        }
        if (n1 > root.key && n2 > root.key) {
            return LCA(root.rightChild, n1, n2);
        }
        return root;
    }

    public Node LCA_Iterative(Node node, int n1, int n2) {
        while (node != null) {
            if (n1 < root.key && n2 < root.key)
                node = node.leftChild;
            else if (n1 > root.key && n2 > root.key)
                node = node.rightChild;
            else
                break; // found
        }
        return node;
    }

    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.leftChild != null)
                queue.add(temp.leftChild);
            if (temp.rightChild != null)
                queue.add(temp.rightChild);
            temp.show();
        }
    }

    public int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.leftChild) + 1;
        int rightHeight = height(root.rightChild) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    public void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            root.show();
        else if (level > 1) {
            printGivenLevel(root.leftChild, level - 1);
            printGivenLevel(root.rightChild, level - 1);
        }
    }

    public void printLevelOrder(Node root) {
        int height = height(root);
        for (int i = 0; i < height; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public void printSpiral(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                if (temp.leftChild != null)
                    s2.push(temp.leftChild);
                if (temp.rightChild != null)
                    s2.push(temp.rightChild);
                temp.show();
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                if (temp.rightChild != null)
                    s1.push(temp.rightChild);
                if (temp.leftChild != null)
                    s1.push(temp.leftChild);
                temp.show();
            }
        }
    }

//    public void printLeftView(Node root) {
//
//    }

    private int distanceFromRoot(Node root, int x) {
        if (root.key == x)
            return 0;
        if (root.key > x)
            return distanceFromRoot(root.leftChild, x) + 1;
        return distanceFromRoot(root.rightChild, x) + 1;
    }

    public int distanceBetween2Nodes(Node node, int n1, int n2) {
        if (root == null)
            return 0;
        if (node.key > n1 && node.key > n2)
            return distanceBetween2Nodes(node.leftChild, n1, n2);
        if (node.key < n1 && node.key < n2)
            return distanceBetween2Nodes(node.rightChild, n1, n2);
        return distanceFromRoot(node, n1) + distanceFromRoot(node, n2);

    }

    public void printKthSmallestElement(Node root, int k) {
        if (root == null)
            return;
        Node current = root;
        int counter = k;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if(current != null) { // first add only left children
                stack.add(current);
                current = current.leftChild;
            }else { // pop left children if counter becomes 0 the print otherwise add right children
                current = stack.pop();
                counter--;
                if(counter == 0) {
                    current.show();
                    return;
                }
                current = current.rightChild; //
            }
        }
    }


    public static void main(String[] args) {
         /*
                  20
               /      \
              10        30
             /  \      /  \
            5   15    25  35
         */
        BinaryTree bst = new BinaryTree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);

//        bst.traverse(1);
//        System.out.println();
//        bst.traverse(2);
//        System.out.println();
//        bst.traverse(3);
        System.out.print("min: ");
        bst.findMin(bst.root);
        System.out.println("level order ");
        bst.levelOrder(bst.root);
        System.out.println("spiral order ");
        bst.printSpiral(bst.root);

        System.out.println("LCA");
        bst.LCA(bst.root, 10, 14).show();
        System.out.println("LCA_Iterative");
        bst.LCA_Iterative(bst.root, 10, 14).show();

        System.out.println("printKthSmallestElement");
        bst.printKthSmallestElement(bst.root, 3);

        System.out.println("size:" + bst.size(bst.root));
        System.out.println("height" + bst.height(bst.root));
        System.out.println("--Level Order--");
        bst.printLevelOrder(bst.root);
        System.out.println("--Left Order--");
//        bst.printLeftView(bst.root, 1);
        System.out.println("--Vertical Order--");
//        bst.printVerticalOrder(bst.root);
        System.out.println("--distanceBetween2Nodes--");
        System.out.println(bst.distanceBetween2Nodes(bst.root, 15, 25));
    }

}


