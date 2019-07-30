package dataStructures;

import java.util.*;
import java.util.LinkedList;
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

    /*
     * node delete
     * have 2 pointer for running current node and parent node
     * find the node to be deleted
     * if no child simply delete by assigning null to parent
     * */
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // loop stops when key matches
        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null) {
                return false; // terminates if not found
            }
        }

        /*
         * Node found can of 3 cases
         * No child
         * One child
         * Two child
         * */

        // no child

        /*
         * current can be root also
         * if both child is null simply assign parent to null
         * [(parent)->(current to be deleted, it can be left or right child of parent)->(current left),(current right)]
         */
        if (current.leftChild == null && current.rightChild == null) {
            // node to be deleted is root
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        // one child

        // if no right child then replace with left subtree
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                // current is left child of parent and also having it's own left child
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;

        }
        // if no left child then replace with right subtree
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }

        // two child


        // current having 2 children so replace with in-order successor
        else {

        }

        return true;
    }

    public void traverse(int order) {
        switch (order) {
            case 1:
                System.out.print("Pre-Order");
                preOrder(root);
                break;
            case 2:
                System.out.print("In-Order");
                inOrder(root);
                break;
            case 3:
                System.out.print("Post-Order");
                postOrder(root);
                break;
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftChild);
            root.show();
            inOrder(root.rightChild);
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            root.show();
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            root.show();
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
    static int max_level = 0;

    public void printLeftView(Node root, int level) {
        if (root == null)
            return;
        if (max_level < level) {
            System.out.println(root.key);
            max_level = level;
        }
        printLeftView(root.leftChild, level + 1);
        printLeftView(root.rightChild, level + 1);
    }

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
            }else { // pop left children, if counter becomes 0, then print otherwise set right children
                current = stack.pop();
                counter--;
                if(counter == 0) {
                    current.show();
                    return;
                }
                current = current.rightChild;
            }
        }
    }

    private void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {

        if (root == null)
            return;

        Vector<Integer> list = m.get(hd);
        if (list == null) {
            list = new Vector<>();
            list.add(root.key);
        } else {
            list.add(root.key);
        }

        m.put(hd, list);

        getVerticalOrder(root.leftChild, hd - 1, m);
        getVerticalOrder(root.rightChild, hd + 1, m);

    }

    public void printVerticalOrder(Node root) {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        int hd = 0;

        getVerticalOrder(root, hd, map);

        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printTopView(Node root) {
        if (root == null)
            return;
        Node current = root;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            current = current.leftChild;
            if (current != null) {
                stack.push(current);
            } else {

            }
        }

    }

    public void printBottomView() {
    }


    public void print2ndLargestElement() {
    }


    public void removeAllLeafNodes() {
    }

    public void sumOfKSmallestElements(int k) {
    }

    // find max value less than or eq to n
    static int findMaxforN(Node root, int n) {
        if (root == null)
            return -1;
        if (root.key == n)
            return root.key;
        else if (root.key < n) {
            int k = findMaxforN(root.rightChild, n);
            if (k == -1)
                return root.key;
            else
                return k;
        } else if (root.key > n)
            return findMaxforN(root.leftChild, n);
        return -1;
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


