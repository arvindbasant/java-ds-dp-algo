package dataStructures;

class Tree {

    class Node {
        int key;
        Node leftChild;
        Node rightChild;

        public Node(int key) {
            this.key = key;
        }

        public void display() {
            System.out.print(key + " ");
        }
    }

    Node root;

    public Tree() {
        root = null;
    }


    public int size(Node root) {
        if (root == null)
            return 0;
        else {
            return size(root.leftChild) + 1 + size(root.rightChild);
        }
    }
//
//    public Node find(int key) {
//        Node current = root;
//        while (current.key != key) {
//            if (key < current.key)
//                current = current.leftChild;
//            else
//                current = current.rightChild;
//            if (current == null)
//                return null; // couldn't found
//        }
//        return current;
//    }
//
//    public void insert(int key) {
//        Node node = new Node(key);
//        if (root == null)
//            root = node;
//        else {
//            Node current = root;
//            Node parent;
//            while (true) {
//                parent = current;
//                if (key < current.key) {
//                    current = current.leftChild;
//                    if (current == null) {
//                        parent.leftChild = node;
//                        return;
//                    }
//                } else {
//                    current = current.rightChild;
//                    if (current == null) {
//                        parent.rightChild = node;
//                        return;
//                    }
//                }
//            }
//        }
//    }


//
//    public void findMin(Node root) {
//        if (root == null)
//            return;
//
//        while (root.leftChild != null) {
//            root = root.leftChild;
//        }
//        root.display();
//
//    }
//
////     using recursion
////     TC: O(h), O(h) extra space for recursive call stack
//    public Node LCA(Node node, int n1, int n2) {
//        if (node == null)
//            return null;
//        if (node.key > n1 && node.key > n2)
//            return LCA(node.leftChild, n1, n2);
//        if (node.key < n1 && node.key < n2)
//            return LCA(node.rightChild, n1, n2);
//
//        return node;
//    }
//
////     TC: O(h), avoids extra white space
//    public Node LCA_Iterative(Node node, int n1, int n2) {
//        while (node != null) {
//            if (node.key > n1 && node.key > n2) {
//                node = node.leftChild;
//            } else if (node.key < n1 && node.key < n2) {
//                node = node.rightChild;
//            } else
//                break;
//        }
//        return node;
//    }

//
//    // using queue
//    public void levelOrderTraversal(Node root) {
//        if (root == null)
//            return;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            Node temp = queue.poll();
//            System.out.print(temp.key + " ");
//            if (temp.leftChild != null)
//                queue.add(temp.leftChild);
//            if (temp.rightChild != null)
//                queue.add(temp.rightChild);
//        }
//    }
//
//    // using two stacks
//    public void printSpiralOrder(Node root) {
//        if (root == null)
//            return;
//        Stack<Node> s1 = new Stack<>();
//        Stack<Node> s2 = new Stack<>();
//        s1.push(root);
//        while (!s1.empty() || !s2.empty()) {
//            while (!s1.empty()) {
//                Node temp = s1.peek();
//                s1.pop();
//                temp.display();
//                if (temp.leftChild != null)
//                    s2.push(temp.leftChild);
//                if (temp.rightChild != null)
//                    s2.push(temp.rightChild);
//            }
//            while (!s2.empty()) {
//                Node temp = s2.peek();
//                s2.pop();
//                temp.display();
//                if (temp.rightChild != null)
//                    s1.push(temp.rightChild);
//                if (temp.leftChild != null)
//                    s1.push(temp.leftChild);
//            }
//        }
//    }

//
//    public void printKthSmallestElement(Node root, int k) {
//        if (root == null)
//            return;
//        Node current = root;
//        Stack<Node> stack = new Stack<>();
//        int counter = k;
//        while (!stack.empty() || current != null) {
//            if (current != null) {
//                stack.add(current);
//                current = current.leftChild;
//            } else {
//                current = stack.pop();
//                counter--;
//                if (counter == 0) {
//                    current.display();
//                    return;
//                }
//                current = current.rightChild;
//            }
//        }
//
//    }
//
//
//
//    public int height(Node root) {
//        if (root == null)
//            return 0;
//        int leftHeight = height(root.leftChild) + 1;
//        int rightHeight = height(root.rightChild) + 1;
//
//        return leftHeight > rightHeight ? leftHeight : rightHeight;
//    }
//
//    public void printLevel(Node root, int level) {
//        if (root == null)
//            return;
//        if (level == 1)
//            root.display();
//        else if (level > 1) {
//            printLevel(root.leftChild, level - 1);
//            printLevel(root.rightChild, level - 1);
//        }
//    }
//
//    public void printLevelOrder(Node root) {
//        int h = height(root);
//        for (int i = 1; i <= h; i++) {
//            System.out.println();
//            printLevel(root, i);
//        }
//    }
//



//
//    private int distanceFromRoot(Node root, int x) {
//
//        if (root.key == x)
//            return 0;
//        if (x < root.key)
//            return distanceFromRoot(root.leftChild, x) + 1;
//
//        return distanceFromRoot(root.rightChild, x) + 1;
//    }
//
//    public int distanceBetween2Nodes(Node root, int a, int b) {
//        if (root == null)
//            return 0;
//        if (root.key > a && root.key > b) {
//            return distanceBetween2Nodes(root.leftChild, a, b);
//        }
//        if (root.key < a && root.key < b) {
//            return distanceBetween2Nodes(root.rightChild, a, b);
//        }
//        return distanceFromRoot(root, a) + distanceFromRoot(root, b);
//
//    }


}

//class BSTMain {
//    public static void main(String[] args) {
//        /*
//                  20
//               /      \
//              10        30
//             /  \      /  \
//            5   15    25  35
//         */
//        Tree bst = new Tree();
//        bst.insert(20);
//        bst.insert(10);
//        bst.insert(5);
//        bst.insert(15);
//        bst.insert(30);
//        bst.insert(25);
//        bst.insert(35);
//
////        bst.traverse(1);
////        System.out.println();
////        bst.traverse(2);
////        System.out.println();
////        bst.traverse(3);
////        System.out.print("min: ");
////        bst.findMin(bst.root);
////        System.out.println("level order ");
////        bst.levelOrderTraversal(bst.root);
////        System.out.println("spiral order ");
////        bst.printSpiralOrder(bst.root);
////
////        System.out.println("LCA");
////        bst.LCA(bst.root, 10, 14).display();
////        System.out.println("LCA_Iterative");
////        bst.LCA_Iterative(bst.root, 10, 14).display();
////
////        System.out.println("printKthSmallestElement");
////        bst.printKthSmallestElement(bst.root, 3);
////
////        System.out.println("size:" + bst.size(bst.root));
////        System.out.println("height" + bst.height(bst.root));
////        System.out.println("--Level Order--");
////        bst.printLevelOrder(bst.root);
////        System.out.println("--Left Order--");
////        bst.printLeftView(bst.root, 1);
////        System.out.println("--Vertical Order--");
////        bst.printVerticalOrder(bst.root);
//        System.out.println("--distanceBetween2Nodes--");
//        System.out.println(bst.distanceBetween2Nodes(bst.root, 10, 5));
//    }
//}